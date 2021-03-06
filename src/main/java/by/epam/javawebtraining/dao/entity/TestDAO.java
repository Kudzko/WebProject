package by.epam.javawebtraining.dao.entity;


import by.epam.javawebtraining.bean.Test;
import by.epam.javawebtraining.bean.TestTheme;
import by.epam.javawebtraining.bean.User;
import by.epam.javawebtraining.dao.AbstractDAO;
import by.epam.javawebtraining.dao.FactoryDAO;
import by.epam.javawebtraining.dao.daointerface.IDdefinition;
import by.epam.javawebtraining.dao.daointerface.ITestDAO;
import by.epam.javawebtraining.dao.exception.DAOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestDAO extends AbstractDAO<Test, Long> implements
        ITestDAO<Test, Long> {
    public static final String ADD_TEST =
            "INSERT INTO `testingproject`.`test` (`author`, `test_theme`, " +
                    "`test_name`) VALUES (?, ?, ?);";
    public static final String UPDATE_TEST =
            "UPDATE `testingproject`.`test` SET `author`=?, `test_theme`= ?, `test_name`= ? WHERE `id` = ?;";
    public static final String DELETE_TEST =
            "DELETE FROM `testingproject`.`test` WHERE `id`=?;";
    public static final String SELECT_TEST =
            "SELECT `id`, `author`, `test_theme`, `test_name` FROM " +
                    "`testingproject`.`test` ";
    public static final String FIND_TEST_BY_ID =
            SELECT_TEST + "WHERE `id` = ?;";
    public static final String FIND_TEST_BY_NAME =
            SELECT_TEST + "WHERE `test_name` = ?;";
    public static final String FIND_TEST_BY_USER_ID =
            SELECT_TEST + "WHERE `user_id` = ?;";
    public static final String FIND_TEST_BY_TEST_ID =
            SELECT_TEST + "WHERE `test_theme` = ?;";
    public static final String SELECT_TESTS =
            SELECT_TEST + ";";

    public static final String FIND_TEST_THEME =
            "SELECT `id`, `test_theme` FROM " +
                    "`testingproject`.`test_theme` WHERE `test_theme`=?;";
    public static final String FIND_TEST_THEME_BY_ID =
            "SELECT `id`, `test_theme` FROM " +
                    "`testingproject`.`test_theme` WHERE `id`=?; ";
    public static final String SELECT_ALL_THEMES =
            "SELECT `id`, `test_theme` FROM " +
                    "`testingproject`.`test_theme`; ";
    public static final String INSERT_TEST_THEME =
            "INSERT INTO `testingproject`.`test_theme` (`test_theme`) VALUES (?);";


    public TestDAO() {
    }

    @Override
    public String getCreateQuery() {
        return ADD_TEST;
    }

    @Override
    public String getUpdateQuery() {
        return UPDATE_TEST;
    }

    @Override
    public void prepareStatementForInsert(Test entity, PreparedStatement preparedStatement) throws SQLException {
        makePrStmtForEntity(entity, preparedStatement);
    }

    @Override
    public void prepareStatementForUpdate(Test entity, PreparedStatement preparedStatement) throws SQLException {
        makePrStmtForEntity(entity, preparedStatement);
        preparedStatement.setLong(4, entity.getId());
    }

    @Override
    protected void makePrStmtForEntity(Test entity, PreparedStatement prpStmt) throws SQLException {
        prpStmt.setLong(1, entity.getAuthor().getId());
        prpStmt.setLong(2, getTestThemeIdHere(entity.getTestTheme()));
        prpStmt.setString(3, entity.getTestName());

    }

    @Override
    public String getDeleteQuery() {
        return DELETE_TEST;
    }

    @Override
    protected Test toEntityBody(ResultSet resultSet) throws SQLException {
        Test test = new Test();

        test.setId(resultSet.getLong("id"));
        test.setAuthor((User) getAuthor(UserDAO.class, resultSet.getLong
                ("author")));
        test.setTestTheme(findThemeById(resultSet.getLong("test_theme")));
        test.setTestName(resultSet.getString("test_name"));
        //test.setQuestionList();

        return test;
    }

    @Override
    public String getSelectAllQuery() {
        return SELECT_TESTS;
    }

    @Override
    public String getSelectQueryByID() {
        return FIND_TEST_BY_ID;
    }


    @Override
    public List<Test> getTestByUserId(long fk) throws DAOException {

        List<Test> listTests = null;
        String SQL = FIND_TEST_BY_USER_ID;

        try {
            PreparedStatement prpStatement = connection.prepareStatement(SQL);
            prpStatement.setLong(1, fk);

            ResultSet rs = prpStatement.executeQuery();
            listTests = toEntity(rs);

        } catch (SQLException e) {
            throw new DAOException("Can not get test by User", e);
        }

        if (listTests == null || listTests.size() == 0) {
            return null;
        }

        return listTests;
    }

    private IDdefinition getAuthor(Class<? extends AbstractDAO> fieldClass,
                                   Long pk) {

        IDdefinition daoInstance = null;
        try {
            parantFactory = FactoryDAO.getInstance();
            UserDAO userDAO = (UserDAO) parantFactory.getDAO(fieldClass);
            userDAO.setConnection(connection);
            daoInstance = userDAO.getByPK(pk);
        } catch (DAOException e) {
            e.printStackTrace();
        }

        return daoInstance;
    }

    public List<Test> getTestByThemeId(long fk) throws DAOException {

        List<Test> listTests = null;
        String SQL = FIND_TEST_BY_TEST_ID;

        try {
            PreparedStatement prpStatement = connection.prepareStatement(SQL);
            prpStatement.setLong(1, fk);

            ResultSet rs = prpStatement.executeQuery();
            listTests = toEntity(rs);

        } catch (SQLException e) {
            throw new DAOException("Can not get test by Theme id", e);
        }

        return listTests;
    }

    public long getTestThemeId(String theme) throws DAOException {
        long themeId;
        try {
            themeId = getTestThemeIdHere(theme);
        } catch (SQLException e) {
            throw new DAOException("Can not get theme id", e);
        }
        return themeId;
    }

    private long getTestThemeIdHere(String theme) throws SQLException {
        long themeId = 0;

        themeId = findTheme(theme);
        if (themeId == 0) {
            themeId = insertTheme(theme);
        }

        return themeId;
    }

    private long insertTheme(String theme) throws SQLException {
        long id = 0;

        PreparedStatement prpStatement = connection.prepareStatement
                (INSERT_TEST_THEME, Statement.RETURN_GENERATED_KEYS);
        prpStatement.setString(1, theme);

        prpStatement.executeUpdate();
        ResultSet generetedKey = prpStatement.getGeneratedKeys();
        if (generetedKey.next()) {
            id = generetedKey.getLong(1);
        }
        return id;
    }

    private long findTheme(String theme) throws SQLException {
        long id = 0;

        PreparedStatement prpStatement = connection.prepareStatement
                (FIND_TEST_THEME);
        prpStatement.setString(1, theme);
        ResultSet rs = prpStatement.executeQuery();

        if (rs.next()) {
            id = rs.getLong("id");
        }

        return id;
    }

    private String findThemeById(long id) throws SQLException {
        String theme = null;

        PreparedStatement prpStatement = connection.prepareStatement
                (FIND_TEST_THEME_BY_ID);
        prpStatement.setLong(1, id);
        ResultSet rs = prpStatement.executeQuery();
        if (rs.next()) {
            theme = rs.getString("test_theme");

        }
        return theme;
    }

    public List<TestTheme> getAllThemes() throws DAOException {
        List<TestTheme> themes = new ArrayList<>();
        try {
            PreparedStatement prpStatement = connection.prepareStatement
                    (SELECT_ALL_THEMES);

            ResultSet rs = prpStatement.executeQuery();

            while (rs.next()) {
                TestTheme testTheme = new TestTheme();
                testTheme.setId(rs.getLong("id"));
                testTheme.setTheme(rs.getString("test_theme"));

                themes.add(testTheme);
            }
        } catch (SQLException e) {
            throw new DAOException("Can not get all themes from DB", e);
        }
        return themes;
    }


}
