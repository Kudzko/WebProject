package by.epam.javawebtraining.dao.entity;

import by.epam.javawebtraining.bean.Answer;
import by.epam.javawebtraining.bean.Entity;
import by.epam.javawebtraining.dao.AbstractDAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AnswerDAO extends AbstractDAO<Answer> {

    public AnswerDAO() {
    }

    @Override
    public void createBody(Answer tEntity, PreparedStatement preparedStatement) throws SQLException {

    }

    @Override
    public void updateBody(Answer tEntity, PreparedStatement preparedStatement) throws SQLException {

    }

    @Override
    public void deleteBody(Answer tEntity, PreparedStatement preparedStatement) throws SQLException {

    }
}
