package by.epam.javawebtraining.service.impementations;

import by.epam.javawebtraining.bean.*;
import by.epam.javawebtraining.dao.AbstractDAO;
import by.epam.javawebtraining.dao.ConnectionPool;
import by.epam.javawebtraining.dao.entity.AnswerDAO;
import by.epam.javawebtraining.dao.entity.QuestionDAO;
import by.epam.javawebtraining.dao.entity.TestDAO;
import by.epam.javawebtraining.dao.exception.DAOException;
import by.epam.javawebtraining.service.AbstractService;
import by.epam.javawebtraining.service.validation.InputTextValidator;
import by.epam.javawebtraining.utils.beanbuilder.TestBuilder;

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
        } finally {
            if (testDAO != null) {
                connectionPool.returnConnection(testDAO.releaseConnectionFromDAO());
            }
        }
        return testThemes;
    }

    public List<Test> getTestByThemeId(long themeId) {
        List<Test> tests = null;
        TestDAO testDAO = null;
        try {
            testDAO = (TestDAO) factoryDAO.getDAO(TestDAO.class);
            testDAO.setConnection(connectionPool.getConnection());
            tests = testDAO.getTestByThemeId(themeId);
        } catch (DAOException e) {
            e.printStackTrace();
        } finally {
            if (testDAO != null) {
                connectionPool.returnConnection(testDAO.releaseConnectionFromDAO());
            }
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
                testDAO = (TestDAO) factoryDAO.getDAO(TestDAO.class);
                Connection connection = connectionPool.getConnection();
                testDAO.setConnection(connection);
                test = testDAO.persist(test);

            } catch (DAOException e) {
                e.printStackTrace();
            } finally {
                connectionPool.returnConnection(testDAO.releaseConnectionFromDAO());
            }
        }

        return test;
    }

    private long getThemeId(String theme) {
        long id = 0;
        TestDAO testDAO = null;
        try {
            testDAO = (TestDAO) factoryDAO.getDAO(TestDAO.class);
            testDAO.setConnection(connectionPool.getConnection());
            id = testDAO.getTestThemeId(theme);

        } catch (DAOException e) {
            e.printStackTrace();
        } finally {
            if (testDAO != null) {
                connectionPool.returnConnection(testDAO.releaseConnectionFromDAO());
            }
        }
        return id;
    }

    public void deleteTest(Test test) {

        Connection connection = connectionPool.getConnection();
        TestDAO testDAO = null;
        QuestionDAO questionDAO = null;
        AnswerDAO answerDAO = null;
        try {
            connection.setAutoCommit(false);
            testDAO = (TestDAO) factoryDAO.getDAO(TestDAO.class);
            questionDAO = (QuestionDAO) factoryDAO.getDAO(QuestionDAO.class);
            answerDAO = (AnswerDAO) factoryDAO.getDAO(AnswerDAO.class);

            testDAO.setConnection(connection);
            questionDAO.setConnection(connection);
            answerDAO.setConnection(connection);

            TestBuilder testBuilder = TestBuilder.getInstance();

            long testId = test.getId();
            Test fullTest = testBuilder.buildTest(testId);
            testDAO.delete(test);

            //checking if question list not null
            if (fullTest.getQuestionList() != null) {
                for (Question item : fullTest.getQuestionList()) {
                    questionDAO.delete(item);
                    //checking if question has answers
                    if (item.getAnswers() != null) {
                        for (Answer answer : item.getAnswers()) {
                            answerDAO.delete(answer);
                        }
                    }
                }
            }
            connection.commit();

        } catch (DAOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (testDAO != null && questionDAO != null && answerDAO != null) {
                connectionPool.returnConnection(testDAO.releaseConnectionFromDAO());
                questionDAO.releaseConnectionFromDAO();
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

    public void updateTest(Test test) {
        TestDAO testDAO = null;
        try {
            testDAO = (TestDAO) factoryDAO.getDAO(TestDAO.class);
            Connection connection = connectionPool.getConnection();
            testDAO.setConnection(connection);
            testDAO.update(test);
        } catch (DAOException e) {
            e.printStackTrace();
        } finally {
            if (testDAO != null) {
                connectionPool.returnConnection(testDAO.releaseConnectionFromDAO());
            }
        }

    }

}
