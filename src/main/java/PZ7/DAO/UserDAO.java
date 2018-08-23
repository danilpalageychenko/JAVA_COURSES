package PZ7.DAO;

import PZ7.Address;
import PZ7.MusicType;
import PZ7.Role;
import PZ7.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gaara on 4/24/17.
 */
public final class UserDAO extends CrudDAO<User> {
    private final String INSERT = "Insert into User (login, password, role, address,musictype) values (?,?,?,?,?)";
    private final String UPDATE = "UPDATE User SET login = ?, password = ?, role = ?,address = ?,musictype = ? ,WHERE id = ?";
    private static UserDAO crudDAO;


    public UserDAO(Class type) {
        super(type);
    }


    public static synchronized UserDAO getInstance() {
        if (crudDAO == null) {
            crudDAO = new UserDAO(User.class);
        }
        return crudDAO;
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, User entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setString(1, entity.getLogin());
        preparedStatement.setString(2, entity.getPassword());
        preparedStatement.setString(3, entity.getRole().getRole());
        preparedStatement.setString(4, entity.getAddress().getAddress());
        preparedStatement.setString(5, entity.getMusicType().getMusicType());
        return preparedStatement;


    }

    @Override
    public PreparedStatement createInsertStatement(Connection connection, User entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, entity.getLogin());
        preparedStatement.setString(2, entity.getPassword());
        preparedStatement.setString(3, entity.getRole().getRole());
        preparedStatement.setString(4, entity.getAddress().getAddress());
        preparedStatement.setString(5, entity.getMusicType().getMusicType());
        return preparedStatement;
    }

    @Override
    public List<User> readAll(ResultSet resultSet) throws SQLException {
        List<User> result = new LinkedList<>();
        User user = null;
        while (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setRole(new Role(resultSet.getString("role")));
            user.setAddress(new Address(resultSet.getString("address")));
            user.setMusicType(new MusicType(resultSet.getString("musictype")));


            result.add(user);


        }
        return result;
    }

}