package lab2.task2;

import java.util.ArrayList;
import java.util.List;

public final class InputConverter {
    public static List<CalculatorRequest> mapRequests(String[] args) {
        List<CalculatorRequest> requests = new ArrayList<>();
        for (int i = 0; i < args.length; i += 3) {
            if (i + 2 < args.length) {
                Object leftOperand = parseOperand(args[i]);
                Object rightOperand = parseOperand(args[i + 2]);
                String operation = args[i + 1];
                requests.add(new CalculatorRequest(leftOperand, rightOperand, operation));
            }
        }
        return requests;
    }

    private static Object parseOperand(String arg) {
        try {
            return Integer.parseInt(arg);
        } catch (NumberFormatException e1) {
            try {
                return Double.parseDouble(arg);
            } catch (NumberFormatException e2) {
                return Boolean.parseBoolean(arg);
            }
        }
    }
}
