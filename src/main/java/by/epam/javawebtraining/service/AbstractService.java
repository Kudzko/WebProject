package by.epam.javawebtraining.service;

import by.epam.javawebtraining.dao.ConnectionPool;
import by.epam.javawebtraining.dao.FactoryDAO;
import by.epam.javawebtraining.service.validation.InputTextValidator;

public class AbstractService {
    protected FactoryDAO factoryDAO = FactoryDAO.getInstance();
    protected ConnectionPool connectionPool = ConnectionPool.getInstance();
    protected InputTextValidator validator = InputTextValidator.getInstance();


    public AbstractService() {
    }
}
