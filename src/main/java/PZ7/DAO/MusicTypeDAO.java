package PZ7.DAO;

import PZ7.MusicType;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gaara on 4/24/17.
 */
public final class MusicTypeDAO extends CrudDAO<MusicType> {
    private final String INSERT = "Insert into User (musictype) values (?)";
    private final String UPDATE = "UPDATE User SET musictype = ? ,WHERE id = ?";
    private static MusicTypeDAO crudDAO;


    public MusicTypeDAO(Class type) {
        super(type);
    }


    public static synchronized MusicTypeDAO getInstance() {
        if (crudDAO == null) {
            crudDAO = new MusicTypeDAO(MusicType.class);
        }
        return crudDAO;
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, MusicType entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setString(1, entity.getMusicType());
        return preparedStatement;


    }

    @Override
    public PreparedStatement createInsertStatement(Connection connection, MusicType entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, entity.getMusicType());
        return preparedStatement;
    }

    @Override
    public List<MusicType> readAll(ResultSet resultSet) throws SQLException {
        List<MusicType> result = new LinkedList<>();
        MusicType musicType = null;
        while (resultSet.next()) {
            musicType = new MusicType();
            musicType.setId(resultSet.getInt("id"));
            musicType.setMusicType(resultSet.getString("musictype"));


            result.add(musicType);


        }
        return result;
    }

}

