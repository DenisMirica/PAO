package lab2.task2;

public class BooleanCalculatorResult extends CalculatorResult {
    public BooleanCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }

    @Override
    public Object computeResult() {
        Boolean leftOperand = (Boolean) getRequest().leftOperand();
        Boolean rightOperand = (Boolean) getRequest().rightOperand();
        String operation = getRequest().operation();

        switch (operation) {
            case "&&":
                return leftOperand && rightOperand;
            case "||":
                return leftOperand || rightOperand;
            default:
                return null;
        }
    }
}
