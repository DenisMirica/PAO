package task5;

import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        List<Double> numbers = InputReader.readNumbers();
        List<Function<Double, Double>> operations = List.of(
                Operations.MULTIPLY_BY_SCALAR2,
                Operations.MULTIPLY_BY_SCALAR3,
                Operations.INCREMENT,
                Operations.INVERSE,
                Operations.SQUARE,
                Operations.SINE,
                Operations.COSINE
        );

        System.out.println("Rezultatele operatiilor:");
        numbers.stream()
                .map(OperationSelector.selectRandomOperation(operations))
                .forEach(result -> System.out.println(result));
    }
}
