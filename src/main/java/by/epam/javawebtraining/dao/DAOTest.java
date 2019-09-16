package by.epam.javawebtraining.dao;


import by.epam.javawebtraining.bean.Role;
import by.epam.javawebtraining.bean.User;
import by.epam.javawebtraining.dao.entity.UserDAO;
import by.epam.javawebtraining.dao.exception.DAOException;

import java.sql.*;


public class DAOTest {
    private static final String DRIVER_NAME = DBProperty.DRIVER;
    private static final String DB_URL = DBProperty.DB_URL;
    private static final String DB_USER = DBProperty.USER_DB;
    private static final String PASSWORD = DBProperty.PASS_DB;

    private static String SQL = "SELECT * from testingproject.role";
    private static String SQL2 = "UPDATE `testingproject`.`user` SET " +
            "`login`=?, `password`= ?, `role_id`= ?, `name`= ?, `surname`= ? " +
            " WHERE `id` = ?;";


    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName(DRIVER_NAME);

            connection = DriverManager.getConnection(DB_URL, DB_USER, PASSWORD);
            FactoryDAO factoryDAO = FactoryDAO.getInstance();

            UserDAO userDAO = (UserDAO) factoryDAO.getDAO(UserDAO.class);
            userDAO.setConnection(connection);
          /*  User user = new User("Сеня","Сериков" , Role.STUDENT, "test1","123" );*/
            User user1 = new User();
       //     userDAO.persist(user);
       //     System.out.println(userDAO.getUserByLogin("test1"));
            System.out.println(user1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DAOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
