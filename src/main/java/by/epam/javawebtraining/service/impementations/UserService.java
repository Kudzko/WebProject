package by.epam.javawebtraining.service.impementations;

import by.epam.javawebtraining.bean.Role;
import by.epam.javawebtraining.bean.User;
import by.epam.javawebtraining.dao.ConnectionPool;
import by.epam.javawebtraining.dao.FactoryDAO;
import by.epam.javawebtraining.dao.entity.UserDAO;
import by.epam.javawebtraining.dao.exception.DAOException;
import by.epam.javawebtraining.service.AbstractService;
import by.epam.javawebtraining.service.validation.InputTextValidator;


import java.sql.Connection;

public class UserService extends AbstractService {
    public static final String[] ROLE = {"student", "tutor"};



    public UserService() {
    }

    public boolean logIn(String login, String password) {
        boolean result = false;

        if ((login != null && login.length() > 0)
                && (password != null && password.length() > 0)) {
            login = login.trim();
            password = password.trim();
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

            if (user.getId() > 0) {
                if (user.getLogin().trim().equals(login)
                        && user.getPassword().trim().equals
                        (password)) {
                    result = true;
                }
            }
        }
        return result;
    }

    public Role getRole(String login) {
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

    public boolean signIn(String name, String surname, String role,
                          String login, String password) {
        boolean result = false;

        if (validator.isValidNameSurname(name)
                && validator.isValidNameSurname(surname)
                && validator.isThereText(role)
                && validator.isThereText(login)
                && validator.isThereText(password)
                && (role.equals(ROLE[0]) || role.equals(ROLE[1]))) {
            login = login.trim();
            password = password.trim();
            name = name.trim();
            surname = surname.trim();

            FactoryDAO factoryDAO = FactoryDAO.getInstance();
            UserDAO userDAO;
            User user = null;

            Connection connection = ConnectionPool.getInstance().getConnection();

            try {
                userDAO = (UserDAO) factoryDAO.getDAO(UserDAO.class);
                userDAO.setConnection(connection);
                user = userDAO.getUserByLogin(login);
                if (user.getId() == 0) {
                    User userTemp = new User(name, surname, Role.valueOf
                            (role.toUpperCase()), login, password);
                    user = userDAO.persist(userTemp);
                    result = true;
                }
            } catch (DAOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public User getUserByLogin(String login) {
        User user = null;
        if (validator.isThereText(login)) {
            UserDAO userDAO = null;
            try {
                userDAO = (UserDAO) factoryDAO.getDAO(UserDAO.class);
                Connection connection = connectionPool.getConnection();
                userDAO.setConnection(connection);
                user = userDAO.getUserByLogin(login);

            } catch (DAOException e) {
                e.printStackTrace();
            }finally {
              connectionPool.returnConnection(userDAO.relizeConnectionFromDAO());
            }
        }
        return user;
    }

}
