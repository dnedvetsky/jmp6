package jdbcconnection;

import jdbcconnection.jdbcmssql.JDBCMSSQLConnector;
import jdbcconnection.jdbcsqlite.JDBCDBSQLiteManager;
import jdbcconnection.jdbcsqlite.JDBCSqliteConnector;

import java.sql.Connection;

/**
 * This is a facade method that composes mssql sqlite, sqlite manager and table manager methods
 */
public class JDBCConnectionFacade {
    private JDBCConnector jdbcmssqlConnector = new JDBCMSSQLConnector();
    private JDBCConnector jdbcSqliteConnector = new JDBCSqliteConnector();
    private JDBCDBSQLiteManager jdbcdbsqLiteManager;
    private JDBCTableManager tableManager;

    /**
     * Initializes SQLite driver
     */
    public void initializeSQLiteDriver() {
        jdbcSqliteConnector.initializeDriver();
    }

    /**
     * Initializes MSSQL driver
     */
    public void initializeMSSQLDriver() {
        jdbcmssqlConnector.initializeDriver();
    }

    /**
     * Creates default JDBC Table
     */
    public void createJDBCDefaultTable() {
        jdbcdbsqLiteManager = new JDBCDBSQLiteManager();
    }

    /**
     * Creates JDBC Table file
     *
     * @param filePath - file path to the Table
     */
    public void createJDBCTable(String filePath) {
        jdbcdbsqLiteManager = new JDBCDBSQLiteManager(filePath);
    }

    /**
     * Defines JDBC Autocommit status
     *
     * @param status - status true or false
     */
    public void setJDBCAutocommitStatus(boolean status) {
        jdbcdbsqLiteManager.setAutocommitStatus(status);
    }


    /**
     * Creates default table with provided name and default table
     *
     * @param tableName - table name
     */
    public void createDefaultTable(String tableName) {
        createDefaultTable(tableName, getTableManager());
    }

    /**
     * Creates default table using provided table manager
     *
     * @param tableName
     * @param tableManager
     */
    public void createDefaultTable(String tableName, JDBCTableManager tableManager) {
        tableManager.execute("CREATE TABLE " + tableName +
                " (ID INT PRIMARY KEY     NOT NULL," +
                " NAME           TEXT    NOT NULL)");
    }

    /**
     * Executes sql query
     *
     * @param sqlQuery     - sql query
     * @param tableManager - table manager
     */
    public void executeDataTableQuery(String sqlQuery, JDBCTableManager tableManager) {
        tableManager.execute(sqlQuery);
    }

    /**
     * Executes sql query using default table manager
     */
    public void executeDataTableQuery(String sqlQuery) {
        executeDataTableQuery(sqlQuery, getTableManager());
    }


    /**
     * Executes update sql query
     *
     * @param sqlQuery - query
     */
    public void updateDataTableQuery(String sqlQuery) {
        updateDataTableQuery(sqlQuery, getTableManager());
    }

    /**
     * Executes update sql query using specified table manager
     *
     * @param sqlQuery
     * @param tableManager
     */
    public void updateDataTableQuery(String sqlQuery, JDBCTableManager tableManager) {
        tableManager.executeUpdate(sqlQuery);
    }

    /**
     * Returns JDBC connection
     *
     * @return Connection
     */
    public Connection getJDBCConnection() {
        return jdbcdbsqLiteManager.getConnection();
    }

    /**
     * Returns table manager
     *
     * @return table manager
     */
    public JDBCTableManager getTableManager() {
        if (this.tableManager != null)
            return this.tableManager;
        return new JDBCTableManager(jdbcdbsqLiteManager.getConnection());
    }
}
