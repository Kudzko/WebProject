package by.epam.javawebtraining.service;

import by.epam.javawebtraining.dao.FactoryDAO;

public class AbstractService {
    protected FactoryDAO factoryDAO = FactoryDAO.getInstance();


    public AbstractService() {
    }
}
