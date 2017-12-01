package dao;

import config.GlobalConfig;

import java.io.IOException;

public class ConnectionBuilderFactory {
    public ConnectionBuilder getConnectionBuilder() throws IOException, ClassNotFoundException {
        if (Class.forName(GlobalConfig.getProperty("db.driver.class")).equals("org.postgres.Driver")) {
            return new PostgresConnectionBuilder();
        } else if (Class.forName(GlobalConfig.getProperty("dbmysql.driver.class")).equals("com.mysql.jdbc.Driver")) {
            return new MySqlConnectionBuilder();
        } else {
            System.out.println("You have no appropriate connection!!!");
        }
        return null;
    }
}
