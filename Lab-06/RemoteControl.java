interface Switchable {

    void on();

    void off();

    default void toggle() {
        System.out.println("Device toggled");
        on();
    }
}

class Fan implements Switchable {

    @Override
    public void on() {
        System.out.println("Fan ON");
    }

    @Override
    public void off() {
        System.out.println("Fan OFF");
    }
}

class Light implements Switchable {

    @SuppressWarnings("override")
    public void on() {
        System.out.println("Light ON");
    }

    @Override
    public void off() {
        System.out.println("Light OFF");
    }
}

@FunctionalInterface
interface SwitchRule {
    boolean maySwitchOn(Switchable device, int hour);
}

public class RemoteControl {

    public static void main(String[] args) {

        Switchable[] devices = {
            new Fan(),
            new Light()
        };

        for (Switchable device : devices) {
            device.on();
            device.toggle();
            device.off();
            System.out.println();
        }

        // Anonymous class
        SwitchRule rule1 = (Switchable device, int hour) -> hour >= 6 && hour <= 22;

        // Lambda
        SwitchRule rule2 =
            (device, hour) -> hour >= 6 && hour <= 22;

        System.out.println("Anonymous class: "
                + rule1.maySwitchOn(devices[0], 10));

        System.out.println("Lambda: "
                + rule2.maySwitchOn(devices[0], 10));
    }
}