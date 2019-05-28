package by.epam.javawebtraining.service.impementations;

import by.epam.javawebtraining.bean.Question;
import by.epam.javawebtraining.dao.entity.QuestionDAO;
import by.epam.javawebtraining.dao.exception.DAOException;
import by.epam.javawebtraining.service.AbstractService;

import java.sql.Connection;
import java.util.List;

public class QuestionService extends AbstractService {

    public Question createQuestion(String questionText, long testId) {
        Question question = new Question();
        if (validator.isThereText(questionText)) {
            question.setQuestionText(questionText);
            question.setTestID(testId);
            QuestionDAO questionDAO = null;

            try {
                questionDAO = (QuestionDAO) factoryDAO.getDAO(QuestionDAO.class);
                Connection connection = connectionPool.getConnection();
                questionDAO.setConnection(connection);
                question = questionDAO.persist(question);


            } catch (DAOException e) {
                e.printStackTrace();
            } finally {
                if (questionDAO.getConnection() != null) {
                    connectionPool.returnConnection(questionDAO.relizeConnectionFromDAO());
                }
            }
        }
        return question;
    }

    public List<Question> getTestQuestionList(long testId) {
        List<Question> questionList = null;
        QuestionDAO questionDAO = null;
        Connection connection;
        try {
            questionDAO = (QuestionDAO) factoryDAO.getDAO(QuestionDAO.class);
            connection = connectionPool.getConnection();
            questionDAO.setConnection(connection);
            questionList = questionDAO.getQuestionByFK(testId);

            } catch (DAOException e) {
            e.printStackTrace();
        }finally {
            if (questionDAO != null){
                connectionPool.returnConnection(questionDAO.relizeConnectionFromDAO());
            }
        }
        return questionList;
    }
}
