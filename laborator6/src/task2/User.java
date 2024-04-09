package task2;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String name;
    private final List<Topic> subscriptions;

    public User(String name) {
        this.name = name;
        this.subscriptions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void subscribeToTopic(Topic topic) {
        subscriptions.add(topic);
        topic.subscribe(this);
    }

    public void receiveNotification(User sender, String topicName, String message) {
        System.out.println(String.format("[%s] %s @ %s: %s", getName(), sender.getName(), topicName, message));
    }
}
