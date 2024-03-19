package lab2.task2;

public final class IntegerCalculatorResult extends CalculatorResult {
    public IntegerCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }

    @Override
    public Object computeResult() {
        Integer leftOperand = (Integer) getRequest().leftOperand();
        Integer rightOperand = (Integer) getRequest().rightOperand();
        String operation = getRequest().operation();

        switch (operation) {
            case "+":
                return leftOperand + rightOperand;
            case "-":
                return leftOperand - rightOperand;
            case "*":
                return leftOperand * rightOperand;
            case "/":
                if (rightOperand != 0) {
                    return leftOperand / rightOperand;
                }
            default:
                return null;
        }
    }
}
