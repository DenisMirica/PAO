package org.example;

import org.example.calculatorResult.PrintingCalculationResult;

import java.sql.*;

public class Main {
    static DatabaseWrapper db = DatabaseWrapper.getInstance();

    public static void main(String[] args) {
        args = new String[]{"1", "+", "2", "2", "*", "5", "1", "+", "5.0", "1.0", "-", "2", "10.0", "/", "2.5"};

        task1(args);
        task2();
        task3(CalculationRequest.RequestType.Integer);
        task4();
    }

    private static void task1(String[] args) {
        try (Connection c = db.getConnection()) {
            try (Statement s = c.createStatement()) {
                String createTable =
                        "CREATE TABLE IF NOT EXISTS smarterCalculatorResults (\n"
                                + "    id INT auto_increment,\n"
                                + "    operation_type VARCHAR(50) NOT NULL,\n"
                                + "    left_operand VARCHAR(200) NOT NULL,\n"
                                + "    right_operand VARCHAR(200) NOT NULL,\n"
                                + "    operation VARCHAR(5) NOT NULL,\n"
                                + "    result VARCHAR(255) NOT NULL\n"
                                + ");";
                s.execute(createTable);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        SmarterCalculator.calculate(args).stream()
                .map(PrintingCalculationResult::new)
                .forEach(
                        result -> {
                            try {
                                result.computeSQLResult();
                            } catch (SQLException e) {
                                System.err.println(e.getMessage());
                            }
                        });
    }

    private static void task2() {
        try (Connection c = db.getConnection()) {
            String selectSql = "SELECT * FROM smarterCalculatorResults";
            try (Statement statement = c.createStatement(); ResultSet resultSet = statement.executeQuery(selectSql)) {
                while (resultSet.next()) {
                    String leftOperand = resultSet.getString("left_operand");
                    String rightOperand = resultSet.getString("right_operand");
                    String operation = resultSet.getString("operation");
                    String operationType = resultSet.getString("operation_type");
                    String result = resultSet.getString("result");
                    System.out.println(leftOperand + " " + operation + " " + rightOperand + " = " + result);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void task3(CalculationRequest.RequestType operationType) {
        try (Connection c = db.getConnection()) {
            String deleteSql = "DELETE FROM smarterCalculatorResults WHERE operation_type = ?";
            try (PreparedStatement preparedStatement = c.prepareStatement(deleteSql)) {
                preparedStatement.setString(1, operationType.toString());
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void task4() {
        try (Connection c = db.getConnection()) {
            String deleteDuplicateSql = "DELETE t1 FROM smarterCalculatorResults t1, smarterCalculatorResults t2 WHERE t1.id < t2.id AND t1.operation_type = t2.operation_type AND t1.left_operand = t2.left_operand AND t1.right_operand = t2.right_operand AND t1.operation = t2.operation AND t1.result = t2.result";
            try (PreparedStatement preparedStatement = c.prepareStatement(deleteDuplicateSql)) {
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
