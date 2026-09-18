@FunctionalInterface
interface Notifier 
{
    void send(String message);
}

interface Urgent 
{
}

public class NotificationDemo 
{
    public static void main(String[] args) 
    {   

        Notifier email = message -> System.out.println("Email: " + message);

        Notifier sms = message -> System.out.println("SMS: " + message);

        Notifier[] senders = { email, sms };

        String message = "Your account has been updated.";

        for (Notifier sender : senders) 
        {
            sender.send(message);

            if (sender instanceof Urgent) 
            {
                sender.send(message);
            }
        }
    }
}