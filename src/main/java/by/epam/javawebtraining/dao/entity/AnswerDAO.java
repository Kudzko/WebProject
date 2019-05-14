package by.epam.javawebtraining.dao.entity;

import by.epam.javawebtraining.bean.Answer;
import by.epam.javawebtraining.bean.Entity;
import by.epam.javawebtraining.bean.Role;
import by.epam.javawebtraining.bean.User;
import by.epam.javawebtraining.dao.AbstractDAO;
import by.epam.javawebtraining.dao.daointerface.IAnswerDAO;
import by.epam.javawebtraining.dao.exception.DAOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AnswerDAO extends AbstractDAO<Answer, Integer> implements IAnswerDAO<Answer, Integer> {
    public static final String ADD_ANSWER =
            "INSERT INTO `testingproject`.`answer` (`answertext`, `right`, `question_id`) VALUES (?, ?, ?);";
    public static final String UPDATE_ANSWER =
            "UPDATE `testingproject`.`answer` SET `answertext`=?, `right`= ?, `question_id`= ? WHERE `id` = ?;";
    public static final String DELETE_ANSWER =
            "DELETE FROM `testingproject`.`answer` WHERE `id`=?;";
    public static final String SELECT =
            "SELECT `id`, `answertext`, `right`, `question_id` FROM " +
                    "testingproject.answer ";
    public static final String FIND_ANSWER_BY_ID =
            SELECT + "WHERE `id` = ?;";
    public static final String SELECT_ANSWERS =
            SELECT + ";";
    public static final String FIND_ANSWER_BY_FK =
            SELECT + "WHERE `question_id` = ?;";

    public AnswerDAO() {
    }


    @Override
    public String getCreateQuery() {
        return ADD_ANSWER;
    }

    @Override
    public String getUpdateQuery() {
        return UPDATE_ANSWER;
    }

    @Override
    public void prepareStatementForInsert(Answer entity, PreparedStatement preparedStatement) throws SQLException {
        makePrStmtForEntity(entity, preparedStatement);
    }

    @Override
    public void prepareStatementForUpdate(Answer entity, PreparedStatement preparedStatement) throws SQLException {
        makePrStmtForEntity(entity, preparedStatement);
        preparedStatement.setLong(4, entity.getId());
    }

    @Override
    protected void makePrStmtForEntity(Answer entity, PreparedStatement prpStmt) throws SQLException {
        prpStmt.setString(1, entity.getAnswerText());
        prpStmt.setBoolean(2, entity.isRight());
        prpStmt.setLong(3, entity.getQuestoinID());
    }

    @Override
    public String getDeleteQuery() {
        return DELETE_ANSWER;
    }

    @Override
    protected Answer toEntityBody(ResultSet resultSet) throws SQLException {
        Answer answer = new Answer();

        answer.setId(resultSet.getInt("id"));
        answer.setAnswerText(resultSet.getString("answertext"));
        answer.setRight(resultSet.getBoolean("right"));
        answer.setQuestoinID(resultSet.getLong("question_id"));

        return answer;
    }

    @Override
    public String getSelectAllQuery() {
        return SELECT_ANSWERS;
    }

    @Override
    public String getSelectQueryByID() {
        return FIND_ANSWER_BY_ID;
    }


    @Override
    public List<Answer> getAnswerByFK(long fk) throws DAOException {

        List<Answer> listAnswers = null;
        String SQL = FIND_ANSWER_BY_FK;

        try {
            PreparedStatement prpStatement = connection.prepareStatement(SQL);
            prpStatement.setLong(1, fk);

            ResultSet rs = prpStatement.executeQuery();
            listAnswers = toEntity(rs);

        } catch (SQLException e) {
            throw new DAOException("Can not get answers by FK", e);
        }

        if (listAnswers == null || listAnswers.size() == 0) {
            return null;
        }

        return listAnswers;
    }
}
