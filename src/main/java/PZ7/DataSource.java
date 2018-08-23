package PZ7;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * Created by gaara on 4/24/17.
 */
public final class DataSource {

    private static ComboPooledDataSource poolConnections;
    private static DataSource dataSource;

    private DataSource(){initPoolConnections();}

    public static synchronized DataSource getInstance()
    {
        if(dataSource == null)
        {
            dataSource = new DataSource();
        }
        return dataSource;
    }

    public Connection getConnection()
    {
        Connection connection = null;
        try {
            connection = poolConnections.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;

    }

    private static void initPoolConnections()
    {
        poolConnections = new ComboPooledDataSource();
        PropertyHolder propertyHolder = PropertyHolder.getInstance();

        try {
            poolConnections.setDriverClass(propertyHolder.getDbDriver());
            poolConnections.setJdbcUrl(propertyHolder.getJdbcURL());
            poolConnections.setUser(propertyHolder.getDbUserLogin());
            poolConnections.setPassword(propertyHolder.getDbUserPassword());

            poolConnections.setMinPoolSize(5);
            poolConnections.setAcquireIncrement(1);
            poolConnections.setMaxPoolSize(100);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }
}
