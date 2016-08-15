package jdbcconnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Dmitry on 15.08.2016.
 */
public class JDBCTableManager {
    private Connection connection;

    /**
     * Constructor with specified connection
     *
     * @param connection - connection used for queries
     */
    public JDBCTableManager(Connection connection) {
        this.connection = connection;
    }

    /**
     * Used to execute update query
     *
     * @param sqlQuery - sql query for execution
     */
    public void executeUpdate(String sqlQuery) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlQuery);
            System.out.println();
            System.out.println("Executed Update: " + sqlQuery);
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Method used to execute query
     *
     * @param sqlQuery - sql query for execution
     */
    public void executeQuery(String sqlQuery) {
        try {
            Statement statement = connection.createStatement();
            statement.executeQuery(sqlQuery);
            System.out.println();
            System.out.println("Executed Query: " + sqlQuery);
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void execute(String sqlQuery) {
        try {
            Statement statement = connection.createStatement();
            statement.execute(sqlQuery);
            System.out.println();
            System.out.println("Executed: " + sqlQuery);
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        connection.close();
        super.finalize();
    }
}
