package org.example.calculatorResult;

import org.example.CalculationRequest;

public abstract class AbstractCalculationResult extends CalculationResult {
    private final CalculationRequest request;

    public AbstractCalculationResult(CalculationRequest request) {
        this.request = request;
    }

    @Override
    public CalculationRequest getRequest() {
        return request;
    }
}