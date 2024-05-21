package task3;

import java.io.*;
import java.net.Socket;
import java.util.Map;

public class ClientHandler implements Runnable {
    private final Socket socket;
    private final Map<String, Topic> topics;
    private String clientName;

    public ClientHandler(Socket socket, Map<String, Topic> topics) {
        this.socket = socket;
        this.topics = topics;
    }

    @Override
    public void run() {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            out.println("Enter your name:");
            clientName = in.readLine();

            out.println("Available topics: " + topics.keySet());
            out.println("Enter the topic you want to subscribe to:");
            String topicName = in.readLine();

            Topic topic = topics.get(topicName);
            if (topic != null) {
                topic.addSubscriber(clientName, out);
                out.println("Subscribed to topic " + topicName);
            } else {
                out.println("Topic not found");
            }

            String message;
            while ((message = in.readLine()) != null) {
                if (topic != null) {
                    topic.broadcastMessage(clientName, message);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
