package com.tuana9a.learn.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
    private Connection connection;

    public boolean connect(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        return connection != null;
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean disconnect() throws SQLException {
        if (connection == null) return true;

        connection.close();
        return connection.isClosed();
    }
}
