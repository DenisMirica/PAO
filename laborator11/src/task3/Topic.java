package task3;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Topic {
    private final String name;
    private final Map<String, PrintWriter> subscribers = new HashMap<>();

    public Topic(String name) {
        this.name = name;
    }

    public void addSubscriber(String clientName, PrintWriter out) {
        subscribers.put(clientName, out);
    }

    public void broadcastMessage(String sender, String message) {
        String formattedMessage = String.format("[%s] %s @ %s: %s", "%s", sender, name, message);
        for (Map.Entry<String, PrintWriter> entry : subscribers.entrySet()) {
            if (!entry.getKey().equals(sender)) {
                entry.getValue().println(String.format(formattedMessage, entry.getKey()));
            }
        }
    }
}
