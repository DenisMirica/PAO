package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExample {
    public static void execute(int totalNumbers) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < totalNumbers; i++) {
            numbers.add(i);
        }

        ExecutorService executor = Executors.newWorkStealingPool();
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (Integer number : numbers) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                int square = number * number;
                System.out.println("CompletableFuture: " + number + "^2=" + square);
            }, executor);
            futures.add(future);
        }

        for (CompletableFuture<Void> future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
    }
}
