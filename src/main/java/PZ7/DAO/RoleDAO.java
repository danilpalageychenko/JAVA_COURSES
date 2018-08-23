package PZ7.DAO;

import PZ7.Role;


import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gaara on 4/24/17.
 */
public final class RoleDAO extends CrudDAO<Role> {
    private final String INSERT = "Insert into User (role) values (?)";
    private final String UPDATE = "UPDATE User SET role = ? ,WHERE id = ?";
    private static RoleDAO crudDAO;


    public RoleDAO(Class type) {
        super(type);
    }


    public static synchronized RoleDAO getInstance() {
        if (crudDAO == null) {
            crudDAO = new RoleDAO(Role.class);
        }
        return crudDAO;
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Role entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setString(1, entity.getRole());
        return preparedStatement;


    }

    @Override
    public PreparedStatement createInsertStatement(Connection connection, Role entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, entity.getRole());
        return preparedStatement;
    }

    @Override
    public List<Role> readAll(ResultSet resultSet) throws SQLException {
        List<Role> result = new LinkedList<>();
        Role role = null;
        while (resultSet.next()) {
            role = new Role();
            role.setId(resultSet.getInt("id"));
            role.setRole(resultSet.getString("role"));


            result.add(role);


        }
        return result;
    }

}
