package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseWrapper {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/laborator";
    private static final String USER = "root";
    private static final String PASSWORD = "mysql1@";

    private static DatabaseWrapper instance;

    private DatabaseWrapper() {}

    public static synchronized DatabaseWrapper getInstance() {
        if (instance == null) {
            instance = new DatabaseWrapper();
        }
        return instance;
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    public static void insertResult(String operationType, String leftOperand, String rightOperand, String operation, String result) {
        String insertSql = "INSERT INTO smarterCalculatorResults(operation_type, left_operand, right_operand, operation, result) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, operationType);
            preparedStatement.setString(2, leftOperand);
            preparedStatement.setString(3, rightOperand);
            preparedStatement.setString(4, operation);
            preparedStatement.setString(5, result);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
