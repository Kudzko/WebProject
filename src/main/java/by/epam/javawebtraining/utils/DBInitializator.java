package by.epam.javawebtraining.utils;

import by.epam.javawebtraining.dao.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBInitializator {

    private ConnectionPool connectionPool = ConnectionPool.getInstance();
    private String sql = DBInitQuery.dbInitQuery;

    public void initDB(){
        Connection connection = connectionPool.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connectionPool.returnConnection(connection);
        }
    }
}
