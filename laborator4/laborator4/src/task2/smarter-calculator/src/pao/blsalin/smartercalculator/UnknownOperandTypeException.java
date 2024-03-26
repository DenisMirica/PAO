package pao.blsalin.smartercalculator;

public class UnknownOperandTypeException extends CalculatorException {
    public UnknownOperandTypeException(String operation) {
        super("Unknown operand type for: " + operation);
    }
}
