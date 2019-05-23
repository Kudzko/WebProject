package by.epam.javawebtraining.service;

import by.epam.javawebtraining.dao.ConnectionPool;
import by.epam.javawebtraining.dao.FactoryDAO;

public class AbstractService {
    protected FactoryDAO factoryDAO = FactoryDAO.getInstance();
    protected ConnectionPool connectionPool = ConnectionPool.getInstance();


    public AbstractService() {
    }
}
