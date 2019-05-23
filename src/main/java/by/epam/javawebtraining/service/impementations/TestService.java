package by.epam.javawebtraining.service.impementations;

import by.epam.javawebtraining.bean.Test;
import by.epam.javawebtraining.bean.TestTheme;
import by.epam.javawebtraining.dao.AbstractDAO;
import by.epam.javawebtraining.dao.ConnectionPool;
import by.epam.javawebtraining.dao.entity.TestDAO;
import by.epam.javawebtraining.dao.exception.DAOException;
import by.epam.javawebtraining.service.AbstractService;

import java.sql.Connection;
import java.util.List;

public class TestService extends AbstractService {

    public TestService() {
    }

    public List<TestTheme> getTestThemes(){
        TestDAO testDAO = null;
        List<TestTheme> testThemes = null;
        try {
         AbstractDAO dao = factoryDAO.getDAO(TestDAO.class);
         if (dao instanceof TestDAO){
             testDAO = (TestDAO) dao;
             Connection connection = ConnectionPool.getInstance().getConnection();
             testDAO.setConnection(connection);
             testThemes = testDAO.getAllThemes();
         }
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return testThemes ;
    }

    public List<Test> getTestByThemeId(long themeId){
        List<Test> tests = null;
        try {
            TestDAO testDAO= (TestDAO) factoryDAO.getDAO(TestDAO.class);
            testDAO.setConnection(connectionPool.getConnection());
            tests = testDAO.getTestByThemeId(themeId);
        } catch (DAOException e) {
            e.printStackTrace();
        }

        return tests;
    }


}
