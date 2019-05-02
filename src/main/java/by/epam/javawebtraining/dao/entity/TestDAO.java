package by.epam.javawebtraining.dao.entity;


import by.epam.javawebtraining.bean.Test;
import by.epam.javawebtraining.bean.User;
import by.epam.javawebtraining.dao.AbstractDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class TestDAO extends AbstractDAO<Test> {
    public static final String ADD_TEST =
            "INSERT INTO `testingproject`.`test` (`author`, `test_theme`, `test_theme`) VALUES (?, ?, ?);";
    public static final String UPDATE_TEST =
            "UPDATE `testingproject`.`test` SET `author`=?, `test_theme`= ?, `test_name`= ? WHERE `id` = ?;";
    public static final String DELETE_TEST =
            "DELETE FROM `testingproject`.`test` WHERE `id`=?;";
    public static final String SELECT_TEST =
            "SELECT `id`, `author`, `test_theme`, `test_name` FROM " +
                    "testingproject.test ";
    public static final String FIND_TEST_BY_ID =
            SELECT_TEST + "WHERE `id` = ?;";
    public static final String FIND_TEST_BY_NAME =
            SELECT_TEST + "WHERE `test_name` = ?;";
    public static final String SELECT_TESTS =
            SELECT_TEST + ";";

    public TestDAO() {
    }

    public Test getTestByID(String id) {
        PreparedStatement preparedStatement = null;
        Test test = null;
        if (id != null) {
            try {
                preparedStatement = connection.prepareStatement(FIND_TEST_BY_NAME);
                preparedStatement.setString(1, id);

                ResultSet resultSet;
                resultSet = preparedStatement.executeQuery();
                test = toEntity(resultSet).get(0);

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeStatement(preparedStatement);
            }
        }

        return test;
    }

    public Test getTestByName(String testName) {
        PreparedStatement preparedStatement = null;
        Test test = null;
        if (testName != null) {
            try {
                preparedStatement = connection.prepareStatement(FIND_TEST_BY_NAME);
                preparedStatement.setString(1, testName);

                ResultSet resultSet;
                resultSet = preparedStatement.executeQuery();
                test = toEntity(resultSet).get(0);

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeStatement(preparedStatement);
            }
        }

        return test;
    }


    public List<Test> getAllTests() {
        Statement stmt = null;
        List<Test> tests = null;
        try {
            stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(SELECT_TESTS);
            tests = toEntity(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tests;
    }

    @Override
    protected Test toEntityBody(ResultSet resultSet) throws SQLException {

        Test test = new Test();

        test.setId(resultSet.getInt("id"));

        FactoryDAO factoryDAO = FactoryDAO.getInstance();
        UserDAO userDAO = factoryDAO.getUserDAO();
        String userID = resultSet.getString("user_id");
        User user = userDAO.getUserByID(userID);
        test.setAuthor(user);

        test.setTestTheme(resultSet.getString("test_theme"));
        test.setTestName(resultSet.getString("test_name"));

        return test;
    }

    @Override
    public void createBody(Test tEntity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement = connection.prepareStatement(ADD_TEST);
        makePrSTMT(tEntity, preparedStatement);
    }

    @Override
    public void updateBody(Test tEntity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement = connection.prepareStatement(UPDATE_TEST);
        makePrSTMT(tEntity, preparedStatement);
    }

    private void makePrSTMT(Test tEntity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, tEntity.getAuthor().getId());
        preparedStatement.setString(2, tEntity.getTestTheme());
        preparedStatement.setString(3, tEntity.getTestName());

        preparedStatement.executeUpdate();
    }

    @Override
    public void deleteBody(Test tEntity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement = connection.prepareStatement(DELETE_TEST);
        preparedStatement.setInt(1, tEntity.getId());

        preparedStatement.executeUpdate();
    }






}
