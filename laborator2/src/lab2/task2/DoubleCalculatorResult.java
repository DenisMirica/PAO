package lab2.task2;

public final class DoubleCalculatorResult extends CalculatorResult {
    public DoubleCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }

    @Override
    public Object computeResult() {
        Object leftOperand = getRequest().leftOperand();
        Object rightOperand = getRequest().rightOperand();
        String operation = getRequest().operation();

        try {
            Double left = Double.parseDouble(leftOperand.toString());
            Double right = Double.parseDouble(rightOperand.toString());

            switch (operation) {
                case "+":
                    return left + right;
                case "-":
                    return left - right;
                case "*":
                    return left * right;
                case "/":
                    if (right != 0) {
                        return left / right;
                    }
                default:
                    return null;
            }
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
