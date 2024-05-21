package task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private final String host;
    private final int port;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() {
        try (
                Socket socket = new Socket(host, port);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader console = new BufferedReader(new InputStreamReader(System.in))
        ) {
            System.out.print(in.readLine());
            String name = console.readLine();
            out.println(name);

            System.out.println(in.readLine());
            System.out.print(in.readLine());
            String topic = console.readLine();
            out.println(topic);

            System.out.println(in.readLine());

            new Thread(() -> {
                try {
                    String response;
                    while ((response = in.readLine()) != null) {
                        System.out.println(response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            String message;
            while ((message = console.readLine()) != null) {
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
                out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
