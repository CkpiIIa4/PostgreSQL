package dao;

import java.io.IOException;

public class ConnectionBuilderFactory {
    public static ConnectionBuilder getConnectionBuilder() throws IOException {
        return new SimpleConnectionBuilder();
    }
}
