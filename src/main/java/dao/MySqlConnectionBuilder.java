package dao;

import config.GlobalConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnectionBuilder implements ConnectionBuilder {

    public MySqlConnectionBuilder() {
        try {
            Class.forName(GlobalConfig.getProperty("dbmysql.driver.class"));
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        String url = GlobalConfig.getProperty("dbmysql.url");
        String login = GlobalConfig.getProperty("dbmysql.login");
        String password = GlobalConfig.getProperty("dbmysql.password");
        return DriverManager.getConnection(url, login, password);
    }
}
