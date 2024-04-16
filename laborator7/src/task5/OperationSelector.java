package task5;

import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class OperationSelector {
    private static final Random random = new Random();

    public static Function<Double, Double> selectRandomOperation(List<Function<Double, Double>> operations) {
        int randomIndex = random.nextInt(operations.size());
        return operations.get(randomIndex);
    }
}
