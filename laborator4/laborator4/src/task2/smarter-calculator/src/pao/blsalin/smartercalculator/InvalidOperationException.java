package pao.blsalin.smartercalculator;
public class InvalidOperationException extends CalculatorException {
    public InvalidOperationException(CalculationRequest request) {
        super("Invalid operation of type "+request.getRequestType()+": " + request);
    }

    public InvalidOperationException(String message, CalculationRequest request) {
        super("Arithmetic error for operation "+ request +" : "+ message);
    }
}