package org.example.calculatorResult;

import java.sql.SQLException;

public class PrintingCalculationResult {
    private final CalculationResult calculationResult;

    public PrintingCalculationResult(CalculationResult calculationResult) {
        this.calculationResult = calculationResult;
    }

    public void computeSQLResult() throws SQLException {
        String resultType = calculationResult.getType();
        String resultValue = calculationResult.getValue();
        System.out.println("Inserting result into database: " + resultType + " -> " + resultValue);
    }
}
