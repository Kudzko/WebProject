package by.epam.javawebtraining.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPool {
    private static ConnectionPool instance = new ConnectionPool();

    private final String DRIVER_NAME = DBProperty.DRIVER;
    private final String DB_URL = DBProperty.DB_URL;
    private final String DB_USER = DBProperty.USER_DB;
    private final String PASSWORD = DBProperty.PASS_DB;

    private int amountConnections;
    private volatile AtomicInteger counterConnections = new AtomicInteger(0);
    private List<Connection> allConnections;
    private BlockingQueue<Connection> connectionQueue;


    private ConnectionPool() {
        this.amountConnections = DBProperty.AMOUNT_CONNECTIONS;
        allConnections = new LinkedList<>();
        connectionQueue = new LinkedBlockingQueue<>(amountConnections);
    }

    public static ConnectionPool getInstance() {
        return instance;
    }

    /**
     * returns connection
     * @return
     */
    public Connection getConnection() {
        Connection connection = null;
        // if connections less then set amount we create ne connection
        if (counterConnections.intValue() < amountConnections) {
            connection = connectionQueue.poll();

            if (connection == null) {
                connection = createConnection();
            }

        } // if connections more then set amount we get connection from queue
        else {
            try {
                connection = connectionQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        try {
            if (!connection.isValid(0)){
                allConnections.remove(connection);
                counterConnections.decrementAndGet();
                connection = getConnection();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    private Connection createConnection() {
        Connection connection = null;
        try {

            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(DB_URL,
                    DB_USER, PASSWORD);
            allConnections.add(connection);
            counterConnections.incrementAndGet();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * method returns connection into connection pool
     * @param connection
     */
    public void returnConnection(Connection connection) {
        try {

            connectionQueue.put(connection);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void closeAllConnections() {
        for (int i = 0; i < allConnections.size(); i++) {
            closeConnection(allConnections.get(i));
        }
    }

    public void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
