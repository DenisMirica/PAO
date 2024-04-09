package task2;

public class Notification {
    private final String recipientName;
    private final String senderName;
    private final String topicName;
    private final String message;

    public Notification(String recipientName, String senderName, String topicName, String message) {
        this.recipientName = recipientName;
        this.senderName = senderName;
        this.topicName = topicName;
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s @ %s: %s", recipientName, senderName, topicName, message);
    }
}

