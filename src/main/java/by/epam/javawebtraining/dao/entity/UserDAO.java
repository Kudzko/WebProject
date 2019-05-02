package by.epam.javawebtraining.dao.entity;

import by.epam.javawebtraining.bean.Role;
import by.epam.javawebtraining.bean.User;
import by.epam.javawebtraining.dao.AbstractDAO;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDAO extends AbstractDAO<User> {
    public static final String ADD_USER =
            "INSERT INTO `testingproject`.`user` (`login`, `password`, `role_id`, `name`, `surname`) VALUES (?, ?, ?, ?, ?);";
    public static final String UPDATE_USER =
            "UPDATE `testingproject`.`user` SET `login`=?, `password`= ?, `role_id`= ?, `name`= ?, `surname`= ? WHERE `id` = ?;";
    public static final String DELETE_USER =
            "DELETE FROM `testingproject`.`user` WHERE `id`=?;";
    public static final String SELECT =
            "SELECT `ìd`, `login`, `password`, `role_id`, `name`, `surname` FROM testingproject.user ";
    public static final String FIND_USER_BY_LOGIN =
            SELECT + "WHERE `login` = ?;";
    public static final String FIND_USER_BY_ID =
            SELECT + "WHERE `id` = ?;";
    public static final String SELECT_USERS =
            SELECT + ";";

    public UserDAO() {
    }



    public User getUserByID(String id) {
        PreparedStatement preparedStatement = null;
        User user = null;
        if (id != null) {
            try {
                preparedStatement = connection.prepareStatement
                        (FIND_USER_BY_ID);
                preparedStatement.setString(1, id);

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


    public List<User> getAllUsers() {
        Statement stmt = null;
        List<User> users = null;
        try {
            stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(SELECT_USERS);
            users = toEntity(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
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

    @Override
    public void createBody(User user, PreparedStatement preparedStatement)
            throws SQLException {
        preparedStatement = connection.prepareStatement(ADD_USER);
        makePrSTMT(user, preparedStatement);
    }

    @Override
    public void updateBody(User user, PreparedStatement preparedStatement)
            throws SQLException {
        preparedStatement = connection.prepareStatement(UPDATE_USER);
        makePrSTMT(user, preparedStatement);
    }

    private void makePrSTMT(User user, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, user.getLogin());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setInt(3, user.getRole().ordinal() + 1);
        preparedStatement.setString(4, user.getName());
        preparedStatement.setString(5, user.getSurname());

        preparedStatement.executeUpdate();
    }

    @Override
    public void deleteBody(User user, PreparedStatement preparedStatement)
            throws SQLException {
        preparedStatement = connection.prepareStatement(DELETE_USER);
        preparedStatement.setInt(1, user.getId());

        preparedStatement.executeUpdate();
    }
}