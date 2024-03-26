package pao.blsalin.smartercalculator.calculatorResult;

import pao.blsalin.smartercalculator.CalculationRequest;
import pao.blsalin.smartercalculator.InvalidOperationException;

public class PrintingCalculationResult implements CalculationResult {

    private final CalculationResult calculationResult;

    public PrintingCalculationResult(CalculationResult calculationResult) {
        this.calculationResult = calculationResult;
    }

    @Override
    public Object computeResult() throws InvalidOperationException {
        try {
            Object result = calculationResult.computeResult();
            CalculationRequest request = calculationResult.getRequest();
            System.out.println("Operation " + request + " has result " + result);
            return result;
        } catch (InvalidOperationException e) {
            System.err.println("InvalidOperationException caught: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public CalculationRequest getRequest() {
        return calculationResult.getRequest();
    }
}
