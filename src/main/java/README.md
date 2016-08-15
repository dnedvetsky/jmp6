The main class is Main.

For this implementation sqlite was used as most appropriate DB that could be used without additional software.
Optional mssql was added, mostly for diversity and demonstration that facade is working.
Personally, some sort of adapter could've reduced code a little bit more, as well as usage of the factory - mostly
connection is an issue, and this can be solved correctly.


The Main application uses JDBCConnectionFacade to access all functionality of an objects composed in the Facade.
Some polymorhism is added just to give more options. SQL query is unimportant - simply used to demonstrate that created
Facade is working correctly.