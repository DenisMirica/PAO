package pao.blsalin.smartercalculator;

public class InvalidArgumentsLengthException extends CalculatorRuntimeException {
    public InvalidArgumentsLengthException(String message) {
        super("Invalid number of arguments");
    }
}