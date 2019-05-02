package by.epam.javawebtraining.dao.entity;

import by.epam.javawebtraining.bean.Entity;
import by.epam.javawebtraining.bean.Result;
import by.epam.javawebtraining.dao.AbstractDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ResultDAO  extends AbstractDAO<Result> {


    public ResultDAO() {
        super();
    }

    @Override
    public void createBody(Result tEntity, PreparedStatement preparedStatement) throws SQLException {

    }

    @Override
    public void updateBody(Result tEntity, PreparedStatement preparedStatement) throws SQLException {

    }

    @Override
    public void deleteBody(Result tEntity, PreparedStatement preparedStatement) throws SQLException {

    }
}
