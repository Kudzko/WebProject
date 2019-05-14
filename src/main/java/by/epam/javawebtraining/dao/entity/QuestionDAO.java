package by.epam.javawebtraining.dao.entity;

import by.epam.javawebtraining.bean.Question;
import by.epam.javawebtraining.dao.AbstractDAO;
import by.epam.javawebtraining.dao.daointerface.IQuestionDAO;
import by.epam.javawebtraining.dao.exception.DAOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class QuestionDAO extends AbstractDAO<Question, Long> implements
        IQuestionDAO<Question, Long> {
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
    public static final String FIND_QUESTION_BY_TEST_ID =
            SELECT_QUESTION + "WHERE `test_id` = ?;";
    public static final String SELECT_QUESTIONS =
            SELECT_QUESTION + ";";

    public QuestionDAO() {
    }

    @Override
    public String getCreateQuery() {
        return ADD_QUESTION;
    }

    @Override
    public String getUpdateQuery() {
        return UPDATE_QUESTION;
    }

    @Override
    public void prepareStatementForInsert(Question entity, PreparedStatement preparedStatement) throws SQLException {
        makePrStmtForEntity( entity,  preparedStatement);
    }

    @Override
    public void prepareStatementForUpdate(Question entity, PreparedStatement preparedStatement) throws SQLException {
        makePrStmtForEntity(entity, preparedStatement);
        preparedStatement.setLong(3, entity.getId());
    }

    @Override
    protected void makePrStmtForEntity(Question entity, PreparedStatement prpStmt) throws SQLException {
        prpStmt.setString(1, entity.getQuestionText());
        prpStmt.setLong(2, entity.getTestID());
    }

    @Override
    public String getDeleteQuery() {
        return DELETE_QUESTION;
    }

    @Override
    protected Question toEntityBody(ResultSet resultSet) throws SQLException {
        Question question = new Question();

        question.setId(resultSet.getLong("id"));
        question.setQuestionText(resultSet.getString("question"));
        question.setTestID(resultSet.getLong("test_id"));
        //question.setAnswers();
        return question;
    }

    @Override
    public String getSelectAllQuery() {
        return SELECT_QUESTIONS;
    }

    @Override
    public String getSelectQueryByID() {
        return FIND_QUESTION_BY_ID;
    }


    @Override
    public List<Question> getQuestionByFK(long fk) throws DAOException {

        List<Question> listQuestions = null;
        String SQL = FIND_QUESTION_BY_TEST_ID;

        try {
            PreparedStatement prpStatement = connection.prepareStatement(SQL);
            prpStatement.setLong(1, fk);

            ResultSet rs = prpStatement.executeQuery();
            listQuestions = toEntity(rs);

        } catch (SQLException e) {
            throw new DAOException("Can not get questions by FK", e);
        }

        if (listQuestions == null || listQuestions.size() == 0) {
            return null;
        }

        return listQuestions;
    }


}
