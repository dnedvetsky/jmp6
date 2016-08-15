package jdbcconnection.jdbcmssql;

import jdbcconnection.JDBCConnector;

/**
 * Created by Dmitry on 15.08.2016.
 */
public class JDBCMSSQLConnector implements JDBCConnector {
    @Override
    public void initializeDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }
    }
}
