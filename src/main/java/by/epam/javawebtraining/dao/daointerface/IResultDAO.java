package by.epam.javawebtraining.dao.daointerface;


import by.epam.javawebtraining.bean.Result;
import by.epam.javawebtraining.dao.exception.DAOException;

import java.util.List;

public interface IResultDAO<Result, Long> extends IAbstractDAO<Result, Long> {

    List<Result> getResultByTestId(long testId) throws DAOException;
    List<Result> getResultByUserId(long testId) throws DAOException;
}
