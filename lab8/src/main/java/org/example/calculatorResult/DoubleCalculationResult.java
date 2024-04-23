package org.example.calculatorResult;

import org.example.CalculationRequest;

public class DoubleCalculationResult implements CalculationResult {
    private final CalculationRequest request;
    private final double result;

    public DoubleCalculationResult(CalculationRequest request) {
        this.request = request;
        this.result = computeDoubleResult();
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

    private double computeDoubleResult() {
        return 0.0;    }
}
