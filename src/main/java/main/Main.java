package main;

import jdbcconnection.JDBCConnectionFacade;

/**
 * Created by Dmitry on 15.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        JDBCConnectionFacade jdbcConnectionFacade = new JDBCConnectionFacade();
        jdbcConnectionFacade.initializeSQLiteDriver();
        jdbcConnectionFacade.createJDBCDefaultTable();
        jdbcConnectionFacade.createDefaultTable("TABLENAME1", jdbcConnectionFacade.getTableManager());
        jdbcConnectionFacade.executeDataTableQuery("DROP TABLE IF EXISTS TABLENAME1;", jdbcConnectionFacade.getTableManager());
        jdbcConnectionFacade.createDefaultTable("TABLENAME2", jdbcConnectionFacade.getTableManager());
        jdbcConnectionFacade.executeDataTableQuery("DROP TABLE IF EXISTS TABLENAME2;", jdbcConnectionFacade.getTableManager());

    }
}
