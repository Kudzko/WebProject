package by.epam.javawebtraining.utils;

import by.epam.javawebtraining.bean.Answer;
import by.epam.javawebtraining.bean.Question;
import by.epam.javawebtraining.bean.Test;
import by.epam.javawebtraining.bean.User;
import by.epam.javawebtraining.dao.ConnectionPool;
import by.epam.javawebtraining.dao.FactoryDAO;
import by.epam.javawebtraining.dao.entity.AnswerDAO;
import by.epam.javawebtraining.dao.entity.QuestionDAO;
import by.epam.javawebtraining.dao.entity.TestDAO;
import by.epam.javawebtraining.dao.entity.UserDAO;
import by.epam.javawebtraining.dao.exception.DAOException;

import java.sql.Connection;
import java.util.List;

public class TestBuilder {
    private static TestBuilder instance = new TestBuilder();
    private FactoryDAO factoryDAO = FactoryDAO.getInstance();


    private TestBuilder() {
    }

    public static TestBuilder getInstance(){
        return instance;
    }

    public  Test buildTest(Long testId) {
        Test test = null;
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        try {
            TestDAO testDAO = (TestDAO) factoryDAO.getDAO(TestDAO.class);
            QuestionDAO questionDAO = (QuestionDAO) factoryDAO.getDAO(QuestionDAO.class);
            AnswerDAO answerDAO = (AnswerDAO) factoryDAO.getDAO(AnswerDAO.class);

            testDAO.setConnection(connection);
            questionDAO.setConnection(connection);
            answerDAO.setConnection(connection);

            test = testDAO.getByPK(testId);
            List<Question> questionList = questionDAO.getQuestionByFK(testId);
            test.setQuestionList(questionList);
            for (Question question:questionList){
                List<Answer> answers = answerDAO.getAnswerByFK(question.getId());
                question.setAnswers(answers);
            }

            connectionPool.returnConnection(testDAO.relizeConnectionFromDAO());
            questionDAO.relizeConnectionFromDAO();
            answerDAO.relizeConnectionFromDAO();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return test;
    }
}
