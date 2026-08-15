abstract class Media {
    String title;

    Media(String title) {
        this.title = title;
    }

    abstract double lateFee(int lateDays);
}

class Book extends Media {

    Book(String title) {
        super(title);
    }

    @Override
    double lateFee(int lateDays) {
        return lateDays * 2;
    }
}

class DVD extends Media {

    DVD(String title) {
        super(title);
    }

    @Override
    double lateFee(int lateDays) {
        return lateDays * 5;
    }
}

class Magazine extends Media {

    Magazine(String title) {
        super(title);
    }

    @Override
    double lateFee(int lateDays) {
        return lateDays * 1;
    }
}

public class MediaDemo {
    public static void main(String[] args) {

        Media[] media = {
            new Book("Java Programming"),
            new DVD("Avengers"),
            new Magazine("Technology Today"),
            new Book("Data Structures")
        };

        int[] lateDays = {3, 4, 5, 2};

        double totalFee = 0;

        for (int i = 0; i < media.length; i++) {

            double fee = media[i].lateFee(lateDays[i]);

            System.out.println("Title: " + media[i].title);
            System.out.println("Type: " + media[i].getClass().getSimpleName());
            System.out.println("Late Days: " + lateDays[i]);
            System.out.println("Late Fee: " + fee);

            totalFee = totalFee + fee;

            System.out.println();
        }

        System.out.println("Total Late Fee = " + totalFee);
    }
}