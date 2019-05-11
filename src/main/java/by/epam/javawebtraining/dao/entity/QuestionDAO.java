package by.epam.javawebtraining.dao.entity;

import by.epam.javawebtraining.bean.Question;
import by.epam.javawebtraining.bean.Test;
import by.epam.javawebtraining.bean.User;
import by.epam.javawebtraining.dao.AbstractDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class QuestionDAO/* extends AbstractDAO<Question>*/ {
    public static final String ADD_QUESTION =
            "INSERT INTO `testingproject`.`question` (`question`, `test_id`) " +
                    "VALUES (?, ?);";
    public static final String UPDATE_QUESTION =
            "UPDATE `testingproject`.`question` SET `question`=?, `test_id`= ? WHERE `id` = ?;";
    public static final String DELETE_QUESTION =
            "DELETE FROM `testingproject`.`question` WHERE `id`=?;";
    public static final String SELECT_QUESTION =
            "SELECT `id`, `question`, `test_id` FROM " +
                    "testingproject.question ";
    public static final String FIND_QUESTION_BY_ID =
            SELECT_QUESTION + "WHERE `id` = ?;";
    public static final String FIND_TEST_BY_TEST_ID =
            SELECT_QUESTION + "WHERE `test_id` = ?;";
    public static final String SELECT_TESTS =
            SELECT_QUESTION + ";";

    public QuestionDAO() {
    }


   /* public Test getTestByID(String id) {
        PreparedStatement preparedStatement = null;
        Test test = null;
        if (id != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_QUESTION);
                preparedStatement.setString(1, id);

                ResultSet resultSet;
                resultSet = preparedStatement.executeQuery();
    //            test = toEntity(resultSet).get(0);

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
*/

//    @Override
//    public void createBody(Question tEntity, PreparedStatement preparedStatement) throws SQLException {
//        preparedStatement = connection.prepareStatement(ADD_QUESTION);
//        makePrSTMT(tEntity, preparedStatement);
//
//    }
//
//    @Override
//    public void updateBody(Question tEntity, PreparedStatement preparedStatement) throws SQLException {
//        preparedStatement = connection.prepareStatement(UPDATE_QUESTION);
//        makePrSTMT(tEntity, preparedStatement);
//    }
//
//    private void makePrSTMT(Question tEntity, PreparedStatement preparedStatement)
//            throws SQLException {
//        preparedStatement.setString(1, tEntity.getQuestionText());
//        preparedStatement.setInt(2, );
//
//
//
//        preparedStatement.executeUpdate();
//    }
//
//    @Override
//    public void deleteBody(Question tEntity, PreparedStatement preparedStatement) throws SQLException {
//        preparedStatement = connection.prepareStatement(DELETE_QUESTION);
//        preparedStatement.setInt(1, tEntity.getId());
//
//        preparedStatement.executeUpdate();
//
//    }
//
//    @Override
//    protected Question toEntityBody(ResultSet resultSet) throws SQLException {
//        Question question = new Question();
//
//        question.setId(resultSet.getInt("id"));
//        question.setQuestionText(resultSet.getString("question"));
//
//        return question;
//    }


}
