package pao.blsalin.smartercalculator;

import pao.blsalin.smartercalculator.InvalidArgumentsLengthException;
import pao.blsalin.smartercalculator.SmarterCalculator;
import pao.blsalin.smartercalculator.calculatorResult.CalculationResult;
import pao.blsalin.smartercalculator.calculatorResult.PrintingCalculationResult;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        args = new String[]{
                "1", "+", "2",
                "2", "*", "5",
                "1", "+", "5.0",
                "1.0", "-", "2",
                "10.0", "/", "1",
        };

        try {
            List<CalculationResult> results = SmarterCalculator.calculate(args);

            for (CalculationResult result : results) {
                PrintingCalculationResult printingResult = new PrintingCalculationResult(result);
                printingResult.computeResult();
            }
        } catch (InvalidArgumentsLengthException e) {
            System.err.println(e.getMessage());
            System.err.println("Please provide a valid number of arguments.");
        } catch (InvalidOperationException e) {
            System.err.println(e.getMessage());
        }
    }
}
