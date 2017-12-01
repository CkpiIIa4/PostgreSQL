package dao;

import config.GlobalConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnectionBuilder implements ConnectionBuilder
{
    public PostgresConnectionBuilder() {
        try {
            Class.forName(GlobalConfig.getProperty("db.driver.class"));
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        String url = GlobalConfig.getProperty("db.url");
        String login = GlobalConfig.getProperty("db.login");
        String password = GlobalConfig.getProperty("db.password");
        Connection con = DriverManager.getConnection(url, login, password);
        return con;
    }


}
