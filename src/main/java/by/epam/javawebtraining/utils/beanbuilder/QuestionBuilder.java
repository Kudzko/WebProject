package by.epam.javawebtraining.utils.beanbuilder;

import by.epam.javawebtraining.bean.Answer;
import by.epam.javawebtraining.bean.Question;
import by.epam.javawebtraining.dao.ConnectionPool;
import by.epam.javawebtraining.dao.FactoryDAO;
import by.epam.javawebtraining.dao.entity.AnswerDAO;
import by.epam.javawebtraining.dao.entity.QuestionDAO;
import by.epam.javawebtraining.dao.entity.TestDAO;
import by.epam.javawebtraining.dao.exception.DAOException;

import java.sql.Connection;
import java.util.List;

public class QuestionBuilder {
    private static QuestionBuilder instance = new QuestionBuilder();
    private FactoryDAO factoryDAO = FactoryDAO.getInstance();

    private QuestionBuilder() {
    }

    public static QuestionBuilder getInstance(){
        return instance;
    }

    public Question buildQuestion(Long questionId){
        Question question = null;

        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        QuestionDAO questionDAO = null;
        AnswerDAO answerDAO = null;
        try {
            questionDAO = (QuestionDAO) factoryDAO.getDAO(QuestionDAO.class);
            answerDAO = (AnswerDAO) factoryDAO.getDAO(AnswerDAO.class);

            questionDAO.setConnection(connection);
            answerDAO.setConnection(connection);

            question = questionDAO.getByPK(questionId);
            List<Answer> answerList = answerDAO.getAnswerByFK(questionId);
            question.setAnswers(answerList);

        } catch (DAOException e) {
            e.printStackTrace();
        }finally {
            if((questionDAO != null) && (answerDAO != null)){
                connectionPool.returnConnection(questionDAO.releaseConnectionFromDAO());
                answerDAO.releaseConnectionFromDAO();
            }
        }

        return question;
    }
}
