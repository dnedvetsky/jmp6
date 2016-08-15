package jdbcconnection.jdbcmssql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class used to manage mssql connection with the provided driver
 */
public class JDBCDBMySQLManager {
    private String url;
    private static String sqliteConnectionMarker = "jdbc:mysql:";
    public Connection connection = null;

    /**
     * Use method to establish connection to database
     */
    public JDBCDBMySQLManager() {
        this("//localhost/test?", "root", "");
    }

    /**
     * Use constructor to establish connection to database with non-default DB name
     *
     * @param url - url to db to get and use as name for database file
     */
    public JDBCDBMySQLManager(String url, String username, String password) {
        this.url = url;
        try {
            this.connection = DriverManager.getConnection(String.format("%s%suser=%s&password=%s", sqliteConnectionMarker, url, username, password));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

    /**
     * This method is used to set autocommit status for JDBC connection
     *
     * @param status - state of autocommit - true or false
     */
    public void setAutocommitStatus(boolean status) {
        try {
            connection.setAutoCommit(status);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to get URL for BD file
     */
    public String getUrl() {
        return this.url;
    }
}
