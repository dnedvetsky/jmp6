package jdbcconnection.jdbcsqlite;

import jdbcconnection.JDBCConnector;

/**
 * Initiate usage of SQLITE driver
 */
public class JDBCSqliteConnector implements JDBCConnector {

    @Override
    public void initializeDriver() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }
    }
}
