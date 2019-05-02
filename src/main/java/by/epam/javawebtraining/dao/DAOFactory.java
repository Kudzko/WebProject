package by.epam.javawebtraining.dao;

import by.epam.javawebtraining.dao.entity.UserDAO;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final UserDAO userDAO = new UserDAO();
}
