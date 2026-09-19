package Discount;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Double> prices = new ArrayList<>();

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();

        System.out.println("Enter prices:");

        for (int i = 0; i < n; i++) {
            prices.add(sc.nextDouble());
        }

        System.out.println("\nChoose Discount Rule:");
        System.out.println("1. 10% Discount");
        System.out.println("2. 20% Discount");
        System.out.println("3. Flat Rs.100 Discount");

        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        DiscountRule rule;

        switch (choice) {

            case 1:
                rule = price -> price * 0.90;
                break;

            case 2:
                rule = price -> price * 0.80;
                break;

            case 3:
                rule = price -> Math.max(0, price - 100);
                break;

            default:
                System.out.println("Invalid choice.");
                sc.close();
                return;
        }

        System.out.println("\nDiscounted Prices:");
        DiscountEngine.applyDiscount(prices, rule);

        sc.close();
    }
}