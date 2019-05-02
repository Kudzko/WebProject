package by.epam.javawebtraining.dao;

import by.epam.javawebtraining.bean.Entity;
import by.epam.javawebtraining.bean.Role;
import by.epam.javawebtraining.bean.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDAO<T> implements IAbstractDAO<T> {
    protected Connection connection;

    public AbstractDAO() {

    }

    public abstract void createBody(T tEntity, PreparedStatement preparedStatement) throws SQLException;

    public abstract void updateBody(T tEntity, PreparedStatement preparedStatement) throws SQLException;

    public abstract void deleteBody(T tEntity, PreparedStatement preparedStatement) throws SQLException;

    protected abstract T toEntityBody(ResultSet resultSet) throws SQLException;


    public void closeStatement(Statement statement) {

        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean create(T entity) {
        PreparedStatement preparedStatement = null;

        T tEntity = (T) entity;
        try {

            createBody(tEntity, preparedStatement);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(preparedStatement);
        }
        return true;

    }

    @Override
    public boolean update(T entity) {
        PreparedStatement preparedStatement = null;

        T tEntity = (T) entity;
        try {

            updateBody(tEntity, preparedStatement);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(preparedStatement);
        }
        return true;
    }

    @Override
    public boolean delete(T entity) {
        PreparedStatement preparedStatement = null;

        T tEntity = (T) entity;
        try {

            deleteBody(tEntity, preparedStatement);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(preparedStatement);
        }

        return true;

    }

    protected List<T> toEntity(ResultSet resultSet) {
        List<T> tEntities = new ArrayList<>();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {

                    T tEntity = toEntityBody(resultSet);

                    tEntities.add(tEntity);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return tEntities;
    }
}
