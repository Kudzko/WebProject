package by.epam.javawebtraining.dao.entity;

import by.epam.javawebtraining.bean.Entity;
import by.epam.javawebtraining.bean.Result;
import by.epam.javawebtraining.bean.Test;
import by.epam.javawebtraining.bean.User;
import by.epam.javawebtraining.dao.AbstractDAO;
import by.epam.javawebtraining.dao.daointerface.IDdefinition;
import by.epam.javawebtraining.dao.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultDAO extends AbstractDAO<Result, Long> {

    public static final String ADD_RESULT =
            "INSERT INTO `testingproject`.`result` (`user_id`, `test_id`,`mark`) " +
                    "VALUES (?, ?, ?);";
    public static final String UPDATE_RESULT =
            "UPDATE `testingproject`.`result` SET `user_id`=?, `test_id`= ?, `mark`= ? WHERE `id` = ?;";
    public static final String DELETE_RESULT =
            "DELETE FROM `testingproject`.`result` WHERE `id`=?;";
    public static final String SELECT_RESULT =
            "SELECT `id`, `user_id`, `test_id`, `mark` FROM " +
                    "`testingproject`.`result` ";
    public static final String FIND_RESULT_BY_ID =
            SELECT_RESULT + "WHERE `id` = ?;";
    public static final String FIND_RESULT_BY_TEST_ID =
            SELECT_RESULT + "WHERE `test_id` = ?;";
    public static final String FIND_RESULT_BY_USER_ID =
            SELECT_RESULT + "WHERE `user_id` = ?;";
    public static final String SELECT_RESULTS =
            SELECT_RESULT + ";";


    public ResultDAO() {
    }

    @Override
    public String getCreateQuery() {
        return ADD_RESULT;
    }

    @Override
    public String getUpdateQuery() {
        return UPDATE_RESULT;
    }

    @Override
    public void prepareStatementForInsert(Result entity, PreparedStatement preparedStatement) throws SQLException {
        makePrStmtForEntity(entity, preparedStatement);
    }

    @Override
    public void prepareStatementForUpdate(Result entity, PreparedStatement preparedStatement) throws SQLException {
        makePrStmtForEntity(entity, preparedStatement);
        preparedStatement.setLong(4, entity.getId());
    }

    @Override
    protected void makePrStmtForEntity(Result entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setLong(1, entity.getStudent().getId());
        preparedStatement.setLong(2, entity.getTest().getId());
        preparedStatement.setDouble(3, entity.getMark());
    }

    @Override
    public String getDeleteQuery() {
        return DELETE_RESULT;
    }

    @Override
    protected Result toEntityBody(ResultSet resultSet) throws SQLException {
        Result result = new Result();

        result.setId(resultSet.getLong("id"));
        result.setStudent((User) getDependence(UserDAO.class, resultSet
                .getLong("user_id")));
        result.setTest((Test) getDependence(TestDAO.class, resultSet
                .getLong("test_id")));
        result.setMark(resultSet.getDouble("mark"));

        return result;
    }

    @Override
    public String getSelectAllQuery() {
        return SELECT_RESULTS;
    }

    @Override
    public String getSelectQueryByID() {
        return FIND_RESULT_BY_ID;
    }


    private IDdefinition getDependence(Class<? extends AbstractDAO> fieldClass,
                                   long
                                           pk) {
        IDdefinition daoInstance = null;
        try {
            daoInstance = parantFactory.getDAO(fieldClass).getByPK(pk);
        } catch (DAOException e) {
            e.printStackTrace();
        }

        return daoInstance;
    }

}
