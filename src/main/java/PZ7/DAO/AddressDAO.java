package PZ7.DAO;

import PZ7.Address;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gaara on 4/24/17.
 */
public final class AddressDAO extends CrudDAO<Address> {
    private final String INSERT = "Insert into User (address) values (?)";
    private final String UPDATE = "UPDATE User SET address = ? ,WHERE id = ?";
    private static AddressDAO crudDAO;


    public AddressDAO(Class type) {
        super(type);
    }


    public static synchronized AddressDAO getInstance() {
        if (crudDAO == null) {
            crudDAO = new AddressDAO(Address.class);
        }
        return crudDAO;
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Address entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setString(1, entity.getAddress());
        return preparedStatement;


    }

    @Override
    public PreparedStatement createInsertStatement(Connection connection, Address entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, entity.getAddress());
        return preparedStatement;
    }

    @Override
    public List<Address> readAll(ResultSet resultSet) throws SQLException {
        List<Address> result = new LinkedList<>();
        Address address = null;
        while (resultSet.next()) {
            address = new Address();
            address.setId(resultSet.getInt("id"));
            address.setAddress(resultSet.getString("address"));


            result.add(address);


        }
        return result;
    }

}
