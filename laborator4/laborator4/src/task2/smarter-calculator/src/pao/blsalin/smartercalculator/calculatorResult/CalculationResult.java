package pao.blsalin.smartercalculator.calculatorResult;

import pao.blsalin.smartercalculator.CalculationRequest;
import pao.blsalin.smartercalculator.InvalidOperationException;

public interface CalculationResult {
    Object computeResult() throws InvalidOperationException;
    CalculationRequest getRequest();
}