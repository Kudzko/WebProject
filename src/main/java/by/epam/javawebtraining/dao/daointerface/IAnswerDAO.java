package by.epam.javawebtraining.dao.daointerface;

import by.epam.javawebtraining.bean.Answer;
import by.epam.javawebtraining.dao.exception.DAOException;

import java.util.List;

public interface IAnswerDAO<Answer, Long> extends IAbstractDAO<Answer, Long>{

    List<Answer> getAnswerByFK(long fk) throws DAOException;
}
