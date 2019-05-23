package by.epam.javawebtraining.dao;

import by.epam.javawebtraining.bean.Question;
import by.epam.javawebtraining.dao.daointerface.IAbstractDAO;
import by.epam.javawebtraining.dao.daointerface.IFactoryDAO;
import by.epam.javawebtraining.dao.entity.*;
import by.epam.javawebtraining.dao.exception.DAOException;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class FactoryDAO implements IFactoryDAO {
    private static final FactoryDAO instance = new FactoryDAO();

    private Map<Class, IFactoryDAO.DaoCreator> daoObjects;

    private FactoryDAO() {
        this.daoObjects = new HashMap<Class, DaoCreator>();

        daoObjects.put(UserDAO.class, new DaoCreator() {
            @Override
            public AbstractDAO create() {
                return new UserDAO();
            }
        });

        daoObjects.put(TestDAO.class, new DaoCreator() {
            @Override
            public AbstractDAO create() {
                return new TestDAO();
            }
        });

        daoObjects.put(ResultDAO.class, new DaoCreator() {
            @Override
            public AbstractDAO create() {
                return new ResultDAO();
            }
        });

        daoObjects.put(QuestionDAO.class, new DaoCreator() {
            @Override
            public AbstractDAO create() {
                return new QuestionDAO();
            }
        });

        daoObjects.put(AnswerDAO.class, new DaoCreator() {
            @Override
            public AbstractDAO create() {
                return new AnswerDAO();
            }
        });
    }

    public static FactoryDAO getInstance() {
        return instance;
    }

    @Override
    public AbstractDAO getDAO( Class daoClass) throws DAOException {
        DaoCreator daoObject = daoObjects.get(daoClass);

        if (daoObject == null) {
            throw new DAOException("Not found DAO object for " + daoClass);
        }
        return daoObject.create();
    }


    }
