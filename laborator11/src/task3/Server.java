package task3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private final int port;
    private final Map<String, Topic> topics = new HashMap<>();

    public Server(int port) {
        this.port = port;
        topics.put("gatit", new Topic("gatit"));
        topics.put("programare", new Topic("programare"));
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new ClientHandler(socket, topics)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
