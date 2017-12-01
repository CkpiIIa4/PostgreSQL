package dao;

import config.GlobalConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnectionBuilder implements ConnectionBuilder {

    public MySqlConnectionBuilder () {
            GlobalConfig.getProperty("daomysql.class");
    }

    @Override
    public Connection getConnection() throws SQLException {
        //String url = GlobalConfig.getProperty("dbmysql.url");
        //String login = GlobalConfig.getProperty("dbmysql.login");
        //String password = GlobalConfig.getProperty("dbmysql.password");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/Customers", "root", "mySQL");
    }
}
