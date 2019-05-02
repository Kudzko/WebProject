package by.epam.javawebtraining.dao.entity;


import by.epam.javawebtraining.bean.Role;
import by.epam.javawebtraining.bean.User;
import by.epam.javawebtraining.dao.ConnectionPool;
import org.junit.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

public class UserDAOTest {
    static Connection connection;
    Statement statement;

    @BeforeClass
    public static void connect() {
        ConnectionPool pool = ConnectionPool.getInstance();
        connection = pool.getConnection();
    }

    @AfterClass
    public static void disconnect() {
        ConnectionPool pool = ConnectionPool.getInstance();
        pool.closeConnection(connection);
    }

    @After
    public void closeStatement() {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void tst_create() {
        String name = "Петр";
        String surname = "Петров";
        String login = "petrov";
        String password = "123";

        User tst_user = new User(name, surname, Role.TUTOR, login, password);
        FactoryDAO factoryDAO = FactoryDAO.getInstance();
        UserDAO userDAO = factoryDAO.getUserDAO();
        userDAO.setConnection(connection);
        userDAO.create(tst_user);

        String testSQL = "SELECT `login`, `password`, `role_id`, `name`, " +
                "`surname` FROM `testingproject`.`user` WHERE " +
                "login = '"+ login +"'  AND password = '"+ password+ "' AND " +
                "role_id =" +
                " 1 AND name = '"+ name +"'  AND surname = '"+surname + "' ;";


        User user = new User();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(testSQL);

            while (resultSet.next()) {

                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setRole(Role.values()[resultSet.getInt("role_id")-1]);


            }

            String deleteTestSQL = "DELETE FROM `testingproject`.`user` WHERE " +
                    "login = '"+ login +"'  AND password = '"+ password+ "' AND " +
                    "role_id =" +
                    " 1 AND name = '"+ name +"'  AND surname = '"+surname + "' ;";

            statement.executeUpdate(deleteTestSQL);

            System.out.println(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        assertTrue("incorrect creating", tst_user.equals(user));


    }

    @Test
    public void tst_update() {

    }

    @Test
    public void tst_delete() {

    }

    @Test
    public void tst_getUserByLogin() {

    }

    @Test
    public void tst_getAllUsers() {

    }

}
