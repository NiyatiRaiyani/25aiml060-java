@FunctionalInterface
interface Notifier {
    void send(String message);
}

interface Urgent {
}

class UrgentNotifier implements Urgent {
}

public class NotificationDemo {
    public static void main(String[] args) {

        // Email sender using lambda
        Notifier email = message ->
                System.out.println("Email: " + message);

        // SMS sender using lambda
        Notifier sms = message ->
                System.out.println("SMS: " + message);

        // Store senders in array
        Notifier[] senders = {email, sms};

        String message = "Your exam is tomorrow.";

        // Broadcast message
        for (Notifier sender : senders) {
            sender.send(message);
        }

        // Urgent notification
        UrgentNotifier urgent = new UrgentNotifier();

        System.out.println("Urgent Notification:");
        email.send(message);
        email.send(message);
    }
}