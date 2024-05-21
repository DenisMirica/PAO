package task2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SequentialExample {
    public static void execute(int totalNumbers) {
        List<Integer> numbers = IntStream.range(0, totalNumbers).boxed().collect(Collectors.toList());

        for (int number : numbers) {
            int square = number * number;
            System.out.println("Sequential: " + number + "^2=" + square);
        }
    }
}
