package by.epam.javawebtraining.dao.daointerface;

import by.epam.javawebtraining.dao.AbstractDAO;
import by.epam.javawebtraining.dao.exception.DAOException;

/**
 * Factory DAO objects for work with DB
 */
public interface IFactoryDAO/*<Connection> */{

    interface DaoCreator {
        AbstractDAO create();
    }


    AbstractDAO getDAO(/*Connection connection, */ Class daoClass) throws DAOException;
}
