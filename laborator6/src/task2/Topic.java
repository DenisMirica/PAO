package task2;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    private final String name;
    private final List<User> subscribers;
    private final List<String> messages;

    public Topic(String name) {
        this.name = name;
        this.subscribers = new ArrayList<>();
        this.messages = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void subscribe(User user) {
        subscribers.add(user);
    }

    public void unsubscribe(User user) {
        subscribers.remove(user);
    }

    public void sendMessage(User sender, String message) {
        messages.add(message);
        notifySubscribers(sender, message);
    }

    private void notifySubscribers(User sender, String message) {
        for (User subscriber : subscribers) {
            if (!subscriber.equals(sender) && subscribers.contains(sender)) {
                subscriber.receiveNotification(sender, name, message);
            }
        }
    }
}
