package by.epam.javawebtraining.dao.entity;

import by.epam.javawebtraining.bean.Entity;
import by.epam.javawebtraining.bean.Test;
import by.epam.javawebtraining.bean.User;
import by.epam.javawebtraining.dao.AbstractDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
    public static final String FIND_TEST_BY_NAME =
            SELECT_TEST + "WHERE `test_name` = ?;";
    public static final String SELECT_TESTS =
            SELECT_TEST + ";";

    public TestDAO() {
    }


   /* public User getUserByLogin(String login) {
        PreparedStatement preparedStatement = null;
        User user = null;
        if (login != null) {
            try {
                preparedStatement = connection.prepareStatement(FIND_USER_BY_LOGIN);
                preparedStatement.setString(1, login);

                ResultSet resultSet;
                resultSet = preparedStatement.executeQuery();
                user = toEntity(resultSet).get(0);

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeStatement(preparedStatement);
            }
        }

        return user;
    }*/


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


    private List<Test> toEntity(ResultSet resultSet) {
        List<Test> tests = new ArrayList<>();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    Test test = new Test();

                    test.setId(resultSet.getInt("id"));

                    FactoryDAO factoryDAO = FactoryDAO.getInstance();
                    UserDAO userDAO = factoryDAO.getUserDAO();
                    String userID = resultSet.getString("user_id");
                    User user = userDAO.getUserByID(userID);

                    test.setAuthor(user);
                    test.setTestTheme(resultSet.getString("test_theme"));
                    test.setTestName(resultSet.getString("test_name"));


                    tests.add(test);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return tests;
    }

    @Override
    public void createBody(Test tEntity, PreparedStatement preparedStatement) throws SQLException {

    }

    @Override
    public void updateBody(Test tEntity, PreparedStatement preparedStatement) throws SQLException {

    }

    @Override
    public void deleteBody(Test tEntity, PreparedStatement preparedStatement) throws SQLException {

    }

    /*
    @Override
    public boolean create(Entity entity) {
        PreparedStatement preparedStatement = null;
        if (entity instanceof Test) {
            Test test = (Test) entity;
            try {
                preparedStatement = connection.prepareStatement(ADD_TEST);
                preparedStatement.setInt(1, test.getAuthor().getId());
                preparedStatement.setString(2, test.getTestTheme());
                preparedStatement.setString(3, test.getTestName());

                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeStatement(preparedStatement);
            }
            return true;
        }

        return false;
    }

    @Override
    public boolean update(Entity entity) {
        PreparedStatement preparedStatement = null;
        if (entity instanceof Test) {
            Test test = (Test) entity;
            try {

                preparedStatement = connection.prepareStatement(UPDATE_TEST);

                preparedStatement.setInt(1, test.getAuthor().getId());
                preparedStatement.setString(2, test.getTestTheme());
                preparedStatement.setString(3, test.getTestName());

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeStatement(preparedStatement);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Entity entity) {
        PreparedStatement preparedStatement = null;
        if (entity instanceof Test) {
            Test test = (Test) entity;
            try {
                preparedStatement = connection.prepareStatement(DELETE_TEST);
                preparedStatement.setInt(1, test.getId());

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeStatement(preparedStatement);
            }

            return true;
        }
        return false;
    }*/
}
