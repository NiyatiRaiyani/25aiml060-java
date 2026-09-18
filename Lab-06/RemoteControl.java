interface Switchable
{
    void on();
    void off();

    default void toggle()
    {
        on();
    }
    }

class fan implements Switchable
{
    @Override
    public void on()
    {
        System.out.println("Fan is on.");
    }
    @Override
    public void off()
    {
        System.out.println("Fan is off");
    }
}

class Light implements Switchable
{
    @Override
    public void on()
    {
        System.out.println("Light is on.");
    }
    @Override
    public void off()
    {
        System.out.println("Light is off.");
    }
}

@FunctionalInterface 
interface permission
{
    boolean MyChoice(String device, int hours);
}

public class RemoteControl
{
    public static void main(String[] args)
    {
       Switchable[] devices = {new fan(), new Light()};

    for (Switchable device : devices)
    {
        device.toggle();
    }
    permission p1=(String device, int hours) -> hours > 6;
        System.out.println("Fan at 8 AM: " + p1.MyChoice("Fan", 8) );

        System.out.println("Light at 5 AM: " + p1.MyChoice("Light", 5));
        
        permission p2 = (device, hour) -> hour > 6;

        System.out.println("Lambda Result:");
        System.out.println("Fan at 8 AM: " + p2.MyChoice("Fan", 8));

        System.out.println("Light at 5 AM: " + p2.MyChoice("Light", 5));
    }
}