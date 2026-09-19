@FunctionalInterface
interface Notifier {
    void send(String message);
}

// Marker interface
interface Urgent {
}

class EmailSender implements Urgent {
}

class SmsSender {
}

public class NotificationDemo {

    public static void main(String[] args) {

        Notifier email = message ->
                System.out.println("Email: " + message);

        Notifier sms = message ->
                System.out.println("SMS: " + message);

        Notifier[] senders = { email, sms };

        String message = "Your account has been updated.";

        // Broadcast message
        for (Notifier sender : senders) {
            sender.send(message);
        }

        // Urgent notification
        Notifier urgentEmail = message1 ->
                System.out.println("URGENT Email: " + message1);

        System.out.println("\nUrgent Notification:");

        urgentEmail.send(message);
        urgentEmail.send(message);
    }
}