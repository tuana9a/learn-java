package com.tuana9a.learn.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
    public static String URL = "jdbc:mysql://localhost:3306/product";

    public static String USER_NAME = "root";
    public static String PASS_WORD = "Tuantai123";

    public static Connection connection;

    public static boolean connect() throws SQLException {
        connection = DriverManager.getConnection(URL, USER_NAME, PASS_WORD);
        return connection != null;
    }

    public static boolean disconnect() throws SQLException {
        if (connection == null) return true;

        connection.close();
        return connection.isClosed();
    }
}
