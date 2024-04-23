package org.example;

import org.example.calculatorResult.CalculationResult;

import java.util.ArrayList;
import java.util.List;

public class SmarterCalculator {
    public static List<CalculationResult> calculate(String[] args) {
        List<CalculationResult> results = new ArrayList<>();

        for (int i = 0; i < args.length; i += 3) {
            String leftOperand = args[i];
            String operation = args[i + 1];
            String rightOperand = args[i + 2];

            double result = performOperation(leftOperand, operation, rightOperand);

            results.add(new CalculationResult(leftOperand, operation, rightOperand, result));
        }

        return results;
    }

    private static double performOperation(String leftOperand, String operation, String rightOperand) {
        double left = Double.parseDouble(leftOperand);
        double right = Double.parseDouble(rightOperand);

        switch (operation) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                if (right == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return left / right;
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }
}
