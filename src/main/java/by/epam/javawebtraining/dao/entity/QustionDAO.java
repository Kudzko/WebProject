package by.epam.javawebtraining.dao.entity;

import by.epam.javawebtraining.bean.Entity;
import by.epam.javawebtraining.dao.AbstractDAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QustionDAO<Qustion>  extends AbstractDAO<Qustion> {

    public QustionDAO() {
    }

    @Override
    public void createBody(Qustion tEntity, PreparedStatement preparedStatement) throws SQLException {

    }

    @Override
    public void updateBody(Qustion tEntity, PreparedStatement preparedStatement) throws SQLException {

    }

    @Override
    public void deleteBody(Qustion tEntity, PreparedStatement preparedStatement) throws SQLException {

    }
}
