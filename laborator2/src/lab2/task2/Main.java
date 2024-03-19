package lab2.task2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        foo(new String[]{"1", "+", "2",
                "2", "*", "5",
                "1", "+", "5.0",
                "1.0", "-", "2",
                "10.0", "/", "1",});
    }

    public static void foo(String[] args) {
        List<CalculatorResult> calculationResults = SmarterCalculator.calculate(args);

        for (CalculatorResult result : calculationResults) {
            CalculatorRequest request = result.getRequest();
            System.out.println("Operation " + request + " has result " + result.computeResult());
        }
    }
}
