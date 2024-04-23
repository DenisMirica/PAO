package org.example.calculatorResult;

public class CalculationResult {
    private final String type;
    private final String value;

    public CalculationResult(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
