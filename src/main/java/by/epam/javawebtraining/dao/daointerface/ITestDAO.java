package by.epam.javawebtraining.dao.daointerface;


import by.epam.javawebtraining.dao.AbstractDAO;
import by.epam.javawebtraining.dao.exception.DAOException;

import java.util.List;

public interface ITestDAO<Test , Integer> extends IAbstractDAO<Test, Integer>{

    List<Test> getTestByUserId(long fk) throws DAOException;
}
