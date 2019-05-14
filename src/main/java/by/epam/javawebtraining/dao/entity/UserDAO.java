package by.epam.javawebtraining.dao.entity;

import by.epam.javawebtraining.bean.Role;
import by.epam.javawebtraining.bean.User;
import by.epam.javawebtraining.dao.AbstractDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends AbstractDAO<User, Long> {
    public static final String ADD_USER =
            "INSERT INTO `testingproject`.`user` (`login`, `password`, `role_id`, `name`, `surname`) VALUES (?, ?, ?, ?, ?);";
    public static final String UPDATE_USER =
            "UPDATE `testingproject`.`user` SET `login`=?, `password`= ?, `role_id`= ?, `name`= ?, `surname`= ? WHERE `id` = ?;";
    public static final String DELETE_USER =
            "DELETE FROM `testingproject`.`user` WHERE `id`=?;";
    public static final String SELECT =
            "SELECT `id`, `login`, `password`, `role_id`, `name`, `surname` " +
                    "FROM testingproject.user ";
    public static final String FIND_USER_BY_LOGIN =
            SELECT + "WHERE `login` = ?;";
    public static final String FIND_USER_BY_ID =
            SELECT + "WHERE `id` = ?;";
    public static final String SELECT_USERS =
            SELECT + ";";

    public UserDAO() {
    }


    @Override
    public String getCreateQuery() {
        return ADD_USER;
    }

    @Override
    public String getUpdateQuery() {
        return UPDATE_USER;
    }

    @Override
    public String getDeleteQuery() {
        return DELETE_USER;
    }

    @Override
    public String getSelectAllQuery() {
        return SELECT_USERS;
    }

    @Override
    public String getSelectQueryByID() {
        return FIND_USER_BY_ID;
    }

    @Override
    public void prepareStatementForInsert(User entity, PreparedStatement preparedStatement) throws SQLException {
        makePrStmtForEntity(entity, preparedStatement);
    }

    @Override
    public void prepareStatementForUpdate(User entity, PreparedStatement preparedStatement) throws SQLException {
        makePrStmtForEntity(entity, preparedStatement);
        preparedStatement.setLong(6, entity.getId());
    }

    @Override
    protected void makePrStmtForEntity(User entity, PreparedStatement prpStmt) throws SQLException {
        prpStmt.setString(1, entity.getLogin());
        prpStmt.setString(2, entity.getPassword());
        prpStmt.setInt(3, entity.getRole().ordinal() + 1);
        prpStmt.setString(4, entity.getName());
        prpStmt.setString(5, entity.getSurname());
    }

    @Override
    protected User toEntityBody(ResultSet resultSet) throws SQLException {
        User user = new User();

        user.setId(resultSet.getInt("id"));
        user.setLogin(resultSet.getString("login"));
        user.setPassword(resultSet.getString("password"));
        user.setName(resultSet.getString("name"));
        user.setSurname(resultSet.getString("surname"));
        user.setRole(Role.values()[resultSet.getInt("role_id")]);

        return user;
    }


    public User getUserByLogin(String login) {
        PreparedStatement preparedStatement = null;
        User user = null;
        if (login != null) {
            try {
                preparedStatement = connection.prepareStatement(FIND_USER_BY_LOGIN);
                preparedStatement.setString(1, login);

                ResultSet resultSet;
                resultSet = preparedStatement.executeQuery();
                user = toEntity(resultSet).get(0);

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeStatement(preparedStatement);
            }
        }

        return user;
    }
}