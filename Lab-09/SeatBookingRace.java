class SeatBooking {
    private int seatsLeft = 5;

    public synchronized void bookSeat() {

        if (seatsLeft > 0) {
            System.out.println(
                Thread.currentThread().getName()
                + " booked a seat."
            );

            seatsLeft--;
        } else {
            System.out.println(
                Thread.currentThread().getName()
                + " could not book a seat."
            );
        }
    }

    public int getSeatsLeft() {
        return seatsLeft;
    }
}

class Customer extends Thread {
    private SeatBooking booking;

    public Customer(SeatBooking booking, String name) {
        super(name);
        this.booking = booking;
    }

    @Override
    public void run() {
        booking.bookSeat();
    }
}

public class SeatBookingRace {
    public static void main(String[] args) throws InterruptedException {

        SeatBooking booking = new SeatBooking();

        Thread[] customers = new Thread[10];

        for (int i = 0; i < 10; i++) {
            customers[i] = new Customer(
                booking,
                "Customer-" + (i + 1)
            );

            customers[i].start();
        }

        for (int i = 0; i < 10; i++) {
            customers[i].join();
        }

        System.out.println("\nSeats Remaining : "
                + booking.getSeatsLeft());
    }
}