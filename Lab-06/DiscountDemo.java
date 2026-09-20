import java.util.*;

@FunctionalInterface
interface DiscountRule {
    double apply(double price);
}

public class DiscountDemo {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            List<Double> prices = new ArrayList<>();
            
            System.out.print("Enter number of products: ");
            int n = sc.nextInt();
            
            System.out.println("Enter prices:");
            
            for (int i = 0; i < n; i++) {
                prices.add(sc.nextDouble());
            }
            
            System.out.println("\nChoose Discount:");
            System.out.println("1. 10% Discount");
            System.out.println("2. 20% Discount");
            System.out.println("3. Rs.100 Discount");
            
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            
            DiscountRule rule;
            
            switch (choice) {
                case 1 -> rule = price -> price * 0.90;
                    
                case 2 -> rule = price -> price * 0.80;
                    
                case 3 -> rule = price -> Math.max(0, price - 100);
                    
                default -> {
                    System.out.println("Invalid choice");
                    sc.close();
                    return;
                }
            }
            
            System.out.println("\nFinal Prices:");
            
            for (double price : prices) {
                double finalPrice = rule.apply(price);
                
                System.out.printf(
                        "Original: %.2f -> Final: %.2f%n",
                        price, finalPrice
                );
            }
        }
    }
}