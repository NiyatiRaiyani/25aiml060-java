class CinemaShow {

    private int seatsAvailable;
    private final int capacity;
    private static int totalBooked = 0;

    // Constructor
    public CinemaShow(String title, int capacity) {
        this.capacity = capacity;
        this.seatsAvailable = capacity;
    }

    // Constructor Chaining
    public CinemaShow(String title) {
        this(title, 100);
    }

    public CinemaShow(int capacity, int seatsAvailable, String title) {
        this.capacity = capacity;
        this.seatsAvailable = seatsAvailable;
    }

    // Book Seats
    public boolean book(int n) {
        if (n <= seatsAvailable) {
            seatsAvailable = seatsAvailable - n;
            totalBooked = totalBooked + n;
            return true;
        } else {
            return false;
        }
    }

    // Cancel Seats
    public void cancel(int n) {
        seatsAvailable = seatsAvailable + n;

        if (seatsAvailable > capacity) {
            seatsAvailable = capacity;
        }
    }

    // Getter
    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    // Static Getter
    public static int getTotalBooked() {
        return totalBooked;
    }

    // Main Method
    public static void main(String[] args) {

        CinemaShow show = new CinemaShow("Avengers", 50);

        System.out.println("Book 20 Seats : " + show.book(20));
        System.out.println("Seats Available : " + show.getSeatsAvailable());

        System.out.println();

        System.out.println("Book 15 Seats : " + show.book(15));
        System.out.println("Seats Available : " + show.getSeatsAvailable());

        System.out.println();

        System.out.println("Book 30 Seats : " + show.book(30));
        System.out.println("Seats Available : " + show.getSeatsAvailable());

        System.out.println();

        show.cancel(10);
        System.out.println("After Cancel 10 Seats");
        System.out.println("Seats Available : " + show.getSeatsAvailable());

        System.out.println();

        System.out.println("Total Booked Seats : " + CinemaShow.getTotalBooked());

    }
}