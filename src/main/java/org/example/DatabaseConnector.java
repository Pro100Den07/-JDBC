package org.example;

import java.sql.*;

public class DatabaseConnector {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/company";
    private static final String DB_USER = "your_username";
    private static final String DB_PASSWORD = "your_password";

    private Connection connection;

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }
        return connection;
    }

    public void executeQuery(String query) throws SQLException {
        try (Statement statement = getConnection().createStatement()) {
            statement.executeUpdate(query);
        }
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
