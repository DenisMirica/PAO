package task1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Running task1.ThreadExample:");
        ThreadExample.execute();

        System.out.println("\nRunning task1.ParallelStreamExample:");
        ParallelStreamExample.execute();

        System.out.println("\nRunning task1.CompletableFutureExample:");
        CompletableFutureExample.execute();
    }
}
