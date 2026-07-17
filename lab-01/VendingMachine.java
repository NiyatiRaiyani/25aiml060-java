import java.util.Scanner;

enum Coin {
    ONE, TWO, FIVE, TEN}
    
public class VendingMachine {

    
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            int price = 15;
            int total = 0;

            System.out.println("===== VENDING MACHINE =====");
            System.out.println("Snack Price = " + price);

            while (total < price) {

                System.out.print("Enter Coin (ONE/TWO/FIVE/TEN): ");

                String input = sc.next().toUpperCase();

                Coin coin;

                try {
                    coin = Coin.valueOf(input);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid Coin! Try Again.");
                    continue;
                }

                int value = switch (coin) {
                    case ONE -> 1;
                    case TWO -> 2;
                    case FIVE -> 5;
                    case TEN -> 10;
                };

                total += value;
                System.out.println("Total Paid = " + total);
            }

            System.out.println("\nPaid.");
            System.out.println("Change : " + (total - price));
        }
    }
}