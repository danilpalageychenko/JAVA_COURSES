package PZ7;

/**
 * Created by gaara on 4/24/17.
 */

import java.io.IOException;
import java.util.Properties;

public final class PropertyHolder {
    private static PropertyHolder propertyHolder;

    private boolean isMemoryDB;
    private String jdbcURL;
    private String dbUserLogin;
    private String dbUserPassword;
    private String dbDriver;

    private PropertyHolder() {loadProperties();}

    public static synchronized PropertyHolder getInstance() {
        if (propertyHolder == null) {
            propertyHolder = new PropertyHolder();
        }
        return propertyHolder;

    }

    private  void loadProperties()
    {
        Properties prop = new Properties();

        try {
            prop.load(PropertyHolder.class.getClassLoader().getResourceAsStream("app.cfg"));

            this.isMemoryDB = Boolean.valueOf(prop.getProperty("isInMemoryDB"));
            this.dbDriver = prop.getProperty("dbDriver");
            this.jdbcURL = prop.getProperty("jdbcUrl");
            this.dbUserLogin = prop.getProperty("dbUserLogin");
            this.dbUserPassword = prop.getProperty("dbUserPassword");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isMemoryDB() {
        return isMemoryDB;
    }

    public String getJdbcURL() {
        return jdbcURL;
    }

    public String getDbUserLogin() {
        return dbUserLogin;
    }

    public String getDbUserPassword() {
        return dbUserPassword;
    }

    public String getDbDriver() {
        return dbDriver;
    }
}