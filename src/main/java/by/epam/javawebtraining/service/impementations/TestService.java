package by.epam.javawebtraining.service.impementations;

import by.epam.javawebtraining.bean.Test;
import by.epam.javawebtraining.bean.TestTheme;
import by.epam.javawebtraining.bean.User;
import by.epam.javawebtraining.dao.AbstractDAO;
import by.epam.javawebtraining.dao.ConnectionPool;
import by.epam.javawebtraining.dao.FactoryDAO;
import by.epam.javawebtraining.dao.entity.AnswerDAO;
import by.epam.javawebtraining.dao.entity.QuestionDAO;
import by.epam.javawebtraining.dao.entity.TestDAO;
import by.epam.javawebtraining.dao.exception.DAOException;
import by.epam.javawebtraining.service.AbstractService;
import by.epam.javawebtraining.service.validation.InputTextValidator;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestService extends AbstractService {
    InputTextValidator validator = InputTextValidator.getInstance();

    public TestService() {
    }

    public List<TestTheme> getTestThemes() {
        TestDAO testDAO = null;
        List<TestTheme> testThemes = null;
        try {
            AbstractDAO dao = factoryDAO.getDAO(TestDAO.class);
            if (dao instanceof TestDAO) {
                testDAO = (TestDAO) dao;
                Connection connection = ConnectionPool.getInstance().getConnection();
                testDAO.setConnection(connection);
                testThemes = testDAO.getAllThemes();
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return testThemes;
    }

    public List<Test> getTestByThemeId(long themeId) {
        List<Test> tests = null;
        try {
            TestDAO testDAO = (TestDAO) factoryDAO.getDAO(TestDAO.class);
            testDAO.setConnection(connectionPool.getConnection());
            tests = testDAO.getTestByThemeId(themeId);
        } catch (DAOException e) {
            e.printStackTrace();
        }

        return tests;
    }

    public Test createTest(String testTheme, String testName, User user) {
        Test test = null;
        TestDAO testDAO = null;
        if (validator.isThereText(testTheme) && validator.isThereText
                (testName) && (user != null)) {
            test = new Test();
            test.setTestTheme(testTheme);
            test.setTestName(testName);
            test.setAuthor(user);

            try {
                testDAO = (TestDAO)factoryDAO.getDAO(TestDAO.class);
                Connection connection = connectionPool.getConnection();
                testDAO.setConnection(connection);
                test = testDAO.persist(test);

            } catch (DAOException e) {
                e.printStackTrace();
            }finally {
                connectionPool.returnConnection(testDAO.relizeConnectionFromDAO());
            }
        }

        return test;
    }

    private long getThemeId (String theme){
        long id = 0;
        TestDAO testDAO = null;
        try {
            testDAO = (TestDAO) factoryDAO.getDAO(TestDAO.class);
            testDAO.setConnection(connectionPool.getConnection());
            id = testDAO.getTestThemeId(theme);

        } catch (DAOException e) {
            e.printStackTrace();
        }finally {
            connectionPool.returnConnection(testDAO.relizeConnectionFromDAO());
        }
        return id;
    }

    public void deleteTest(Test test){
        Connection connection = connectionPool.getConnection();
        try {
            connection.setAutoCommit(false);
            TestDAO testDAO = (TestDAO) factoryDAO.getDAO(TestDAO.class);
            QuestionDAO questionDAO = (QuestionDAO) factoryDAO.getDAO(QuestionDAO.class);
            AnswerDAO answerDAO = (AnswerDAO) factoryDAO.getDAO(AnswerDAO.class);

        } catch (DAOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
