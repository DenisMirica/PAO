package task5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader {
    public static List<Double> readNumbers() {
        List<Double> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceti numarul total de numere:");
        int totalNumbers = readInt(scanner);

        for (int i = 0; i < totalNumbers; i++) {
            double number = readNumber(scanner, i + 1);
            numbers.add(number);
        }

        return numbers;
    }

    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static double readNumber(Scanner scanner, int index) {
        while (!scanner.hasNextDouble()) {
            System.out.println("Introduceti un numar valid pentru numarul " + index + ":");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}
