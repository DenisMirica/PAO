package org.example.calculatorResult;

import org.example.CalculationRequest;

public class IntegerCalculationResult implements CalculationResult {
    private final CalculationRequest request;
    private final int result;

    public IntegerCalculationResult(CalculationRequest request) {
        this.request = request;
        this.result = computeIntegerResult();
    }

    @Override
    public Object computeResult() {
        return result;
    }

    @Override
    public CalculationRequest getRequest() {
        return request;
    }

    @Override
    public Object getResult() {
        return result;
    }

    private int computeIntegerResult() {
        return 0;
    }
}
