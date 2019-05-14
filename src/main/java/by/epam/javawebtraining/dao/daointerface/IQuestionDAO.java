package by.epam.javawebtraining.dao.daointerface;

import by.epam.javawebtraining.bean.Question;
import by.epam.javawebtraining.dao.exception.DAOException;

import java.util.List;

public interface IQuestionDAO<Question, Integer> extends IAbstractDAO<Question, Integer> {
    List<Question> getQuestionByFK(long fk) throws DAOException;
}
