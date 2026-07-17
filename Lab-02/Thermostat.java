class Thermostat {

// Instance Variables
        private int temperature;

    // Static Constants
    private static final int MIN = 16;
    private static final int MAX = 30;

    // Static Variable
    private static int activeCount = 0;

    // Constructor with location and startTemp
    public Thermostat(String location, int startTemp) {

        if (startTemp >= MIN && startTemp <= MAX) {
            this.temperature = startTemp;
        } else {
            this.temperature = 22;
        }

        activeCount++;
    }

    // Constructor Chaining
    public Thermostat(String location) {
        this(location, 22);
    }

    // Raise Temperature
    public void raise() {
        if (temperature < MAX) {
            temperature++;
        } else {
            System.out.println("Already at maximum (30)");
        }
    }

    // Lower Temperature
    public void lower() {
        if (temperature > MIN) {
            temperature--;
        } else {
            System.out.println("Already at minimum (16)");
        }
    }

    // Getter
    public int getTemperature() {
        return temperature;
    }

    // Static Getter
    public static int getActiveCount() {
        return activeCount;
    }

    // Main Method
    public static void main(String[] args) {

        Thermostat t1 = new Thermostat("Hall");

        System.out.println("Increasing Temperature:");

        for (int i = 1; i <= 10; i++) {
            t1.raise();
            System.out.println("Temperature = " + t1.getTemperature());
        }

        System.out.println();

        System.out.println("Decreasing Temperature:");

        for (int i = 1; i <= 20; i++) {
            t1.lower();
            System.out.println("Temperature = " + t1.getTemperature());
        }

        System.out.println();

        System.out.println("Active Thermostats = " + Thermostat.getActiveCount());
    }
}