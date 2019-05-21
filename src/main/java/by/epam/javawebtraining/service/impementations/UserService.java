package by.epam.javawebtraining.service.impementations;

import by.epam.javawebtraining.bean.Role;
import by.epam.javawebtraining.bean.User;
import by.epam.javawebtraining.dao.ConnectionPool;
import by.epam.javawebtraining.dao.FactoryDAO;
import by.epam.javawebtraining.dao.entity.UserDAO;
import by.epam.javawebtraining.dao.exception.DAOException;
import by.epam.javawebtraining.service.AbstractService;

import java.sql.Connection;

public class UserService extends AbstractService {

    public UserService() {
    }

    public boolean logIn(String login, String password) {
        login.trim();
        password.trim();
        FactoryDAO factoryDAO = FactoryDAO.getInstance();
        UserDAO userDAO;
        User user = null;
        boolean result = false;

       Connection connection = ConnectionPool.getInstance().getConnection();

        try {
            userDAO = (UserDAO) factoryDAO.getDAO(UserDAO.class);
            userDAO.setConnection(connection);
            user = userDAO.getUserByLogin(login);
        } catch (DAOException e) {
            e.printStackTrace();
        }

        if (user.getId() > 0){
            if (user.getLogin().trim().equals(login)
                    && user.getPassword().trim().equals
                    (password)){
                result = true;
            }
        }

        return result;
    }

    public Role getRole (String login){
        FactoryDAO factoryDAO = FactoryDAO.getInstance();
        UserDAO userDAO;
        User user = null;
        Connection connection = ConnectionPool.getInstance().getConnection();

        try {
            userDAO = (UserDAO) factoryDAO.getDAO(UserDAO.class);
            userDAO.setConnection(connection);
            user = userDAO.getUserByLogin(login);
        } catch (DAOException e) {
            e.printStackTrace();
        }

        return user.getRole();
    }
}
