package PZ3;

import java.sql.*;

/**
 * Created by gaara on 12.08.16.
 */
public class MysqlConnector {
    private static final String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "9dOCUzM1rBVK111";


    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;


    public static void makeQuaryUpdate(String query) {
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            //stmt.executeQuery(query);
            stmt.executeUpdate(query);

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
        }

    }


    public static String makeQuaryString(String query,String columnName) {
        String ans = new String();
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);
            rs.next();
            ans = rs.getString(columnName);

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
        return ans;
    }
}
