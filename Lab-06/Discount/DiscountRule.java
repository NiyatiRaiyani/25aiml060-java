package Discount;

@FunctionalInterface
public interface DiscountRule {
    double apply(double price);
}