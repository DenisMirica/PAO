package task4;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int N = 10;
        IntStream.rangeClosed(1, N)
                .filter(num -> num % 2 == 0)
                .mapToObj(num -> new Object() {
                    int number = num;
                    int square = num * num;
                })
                .forEach(obj -> System.out.println("Numar: " + obj.number + ", Patrat: " + obj.square));
    }
}

