package by.epam.javawebtraining.service.impementations;

import by.epam.javawebtraining.bean.Answer;
import by.epam.javawebtraining.bean.Question;
import by.epam.javawebtraining.dao.entity.AnswerDAO;
import by.epam.javawebtraining.dao.entity.QuestionDAO;
import by.epam.javawebtraining.dao.exception.DAOException;
import by.epam.javawebtraining.service.AbstractService;
import by.epam.javawebtraining.utils.beanbuilder.QuestionBuilder;

import java.sql.Connection;
import java.sql.SQLException;
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
                    connectionPool.returnConnection(questionDAO.releaseConnectionFromDAO());
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
        } finally {
            if (questionDAO != null) {
                connectionPool.returnConnection(questionDAO.releaseConnectionFromDAO());
            }
        }
        return questionList;
    }

    public void update(Long questionId, String questionText, Long testId) {
        Question question = new Question();
        QuestionDAO questionDAO = null;
        Connection connection = null;

        question.setId(questionId);
        question.setQuestionText(questionText);
        question.setTestID(testId);

        try {
            questionDAO = (QuestionDAO) factoryDAO.getDAO(QuestionDAO.class);
            connection = connectionPool.getConnection();
            questionDAO.setConnection(connection);
            questionDAO.update(question);


        } catch (DAOException e) {
            e.printStackTrace();
        } finally {
            if (questionDAO != null) {
                connectionPool.returnConnection(questionDAO.releaseConnectionFromDAO());
            }
        }

    }

    public void delete(Long questionId) {
        QuestionDAO questionDAO = null;
        AnswerDAO answerDAO = null;
        Connection connection = null;
        try {
            questionDAO = (QuestionDAO) factoryDAO.getDAO(QuestionDAO.class);
            answerDAO = (AnswerDAO) factoryDAO.getDAO(AnswerDAO.class);
            connection = connectionPool.getConnection();
            connection.setAutoCommit(false);
            questionDAO.setConnection(connection);
            answerDAO.setConnection(connection);

            QuestionBuilder questionBuilder = QuestionBuilder.getInstance();

            Question fullQuestion = questionBuilder.buildQuestion(questionId);
            questionDAO.delete(fullQuestion);

            //checking if question has answers
            if (fullQuestion.getAnswers() != null) {
                for (Answer item : fullQuestion.getAnswers()) {
                    answerDAO.delete(item);
                }
            }
            connection.commit();
        } catch (DAOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (questionDAO != null && answerDAO != null) {
                connectionPool.returnConnection(questionDAO.releaseConnectionFromDAO());
                answerDAO.releaseConnectionFromDAO();
            }
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public Question getByPK(Long id){
        Question question = null;
        QuestionDAO questionDAO = null;
        Connection connection = null;
        try {
            questionDAO = (QuestionDAO) factoryDAO.getDAO(QuestionDAO.class);
            connection = connectionPool.getConnection();
            questionDAO.setConnection(connection);
            question = questionDAO.getByPK(id);
        } catch (DAOException e) {
            e.printStackTrace();
        }finally {
            if (questionDAO != null){
                connectionPool.returnConnection(questionDAO.releaseConnectionFromDAO());
            }
        }

        return question;
    }
}
