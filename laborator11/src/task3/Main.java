package task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        new Thread(() -> new Server(12345).start()).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try (
                BufferedReader console = new BufferedReader(new InputStreamReader(System.in))
        ) {
            while (true) {
                System.out.println("Enter client name (or 'exit' to quit):");
                String name = console.readLine();
                if (name.equalsIgnoreCase("exit")) {
                    break;
                }

                new Thread(() -> new Client("localhost", 12345).start()).start();

                Thread.sleep(500);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
