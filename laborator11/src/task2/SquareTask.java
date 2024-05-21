package task2;

import java.util.List;

public class SquareTask implements Runnable {
    private List<Integer> numbers;
    private String method;

    public SquareTask(List<Integer> numbers, String method) {
        this.numbers = numbers;
        this.method = method;
    }

    @Override
    public void run() {
        for (int number : numbers) {
            int square = number * number;
            System.out.println(method + ": " + number + "^2=" + square);
        }
    }
}
