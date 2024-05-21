package task1;

import java.util.ArrayList;
import java.util.List;

public class ThreadExample {
    public static void execute() {
        int numThreads = Runtime.getRuntime().availableProcessors();
        int totalNumbers = 10000;
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < totalNumbers; i++) {
            numbers.add(i);
        }

        int chunkSize = totalNumbers / numThreads;
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end = (i == numThreads - 1) ? totalNumbers : start + chunkSize;
            Thread thread = new Thread(new SquareTask(numbers.subList(start, end), "Thread"));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
