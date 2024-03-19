package lab2.task2;

import java.util.ArrayList;
import java.util.List;

public final class SmarterCalculator {
    public static List<CalculatorResult> calculate(String[] args) {
        List<CalculatorRequest> requests = InputConverter.mapRequests(args);
        List<CalculatorResult> results = new ArrayList<>();

        for (CalculatorRequest request : requests) {
            switch (request.getRequestType()) {
                case "Integer":
                    results.add(new IntegerCalculatorResult(request));
                    break;
                case "Double":
                    results.add(new DoubleCalculatorResult(request));
                    break;
                case "Boolean":
                    results.add(new BooleanCalculatorResult(request));
                    break;
            }
        }

        return results;
    }
}
