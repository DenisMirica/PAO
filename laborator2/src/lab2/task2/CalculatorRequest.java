package lab2.task2;

public record CalculatorRequest(Object leftOperand, Object rightOperand, String operation) {
    public String getRequestType() {
        if (leftOperand instanceof Boolean && rightOperand instanceof Boolean) {
            return "Boolean";
        } else if (leftOperand instanceof Integer && rightOperand instanceof Integer) {
            return "Integer";
        } else if (leftOperand instanceof Double || rightOperand instanceof Double) {
            return "Double";
        } else {
            return "Error";
        }
    }

    @Override
    public String toString() {
        return leftOperand + " " + operation + " " + rightOperand;
    }
}
