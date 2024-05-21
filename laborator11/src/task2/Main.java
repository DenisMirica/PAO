package task2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> testSizes = Arrays.asList(10, 1000, 10000, 10000000);
        String[] methods = {"Sequential", "Thread", "ParallelStream", "CompletableFuture"};

        try (FileWriter writer = new FileWriter("timing_results.txt")) {
            for (int size : testSizes) {
                for (String method : methods) {
                    long startTime = System.nanoTime();

                    switch (method) {
                        case "Sequential":
                            SequentialExample.execute(size);
                            break;
                        case "Thread":
                            ThreadExample.execute(size);
                            break;
                        case "ParallelStream":
                            ParallelStreamExample.execute(size);
                            break;
                        case "CompletableFuture":
                            CompletableFutureExample.execute(size);
                            break;
                    }

                    long endTime = System.nanoTime();
                    double duration = (endTime - startTime) / 1_000_000_000.0;
                    writer.write(String.format("%s, %d elements: %.9f s%n", method, size, duration));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
