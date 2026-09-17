class OutOfStockException extends Exception {
    int shortfall;

    OutOfStockException(String msg, int shortfall) {
        super(msg);
        this.shortfall = shortfall;
    }

    public int getShortfall() {
        return shortfall;
    }

}

class InvalidQuantityException extends Exception {
    InvalidQuantityException(String msg) {
        super(msg);
    }
}

class Warehouse {
    int stock = 10;

    void issue(String item, int qty)
            throws OutOfStockException, InvalidQuantityException {

        if (qty <= 0) {
            throw new InvalidQuantityException(
                "Invalid quantity for " + item
            );
        }

        if (qty > stock) {
            int shortfall = qty - stock;

            throw new OutOfStockException(
                "Out of stock for " + item +
                ". Shortfall = " + shortfall,
                shortfall
            );
        }

        stock = stock - qty;

        System.out.println(
            qty + " " + item + " issued successfully."
        );
        System.out.println("Remaining stock = " + stock);
    }
}

public class StockIssue {
    public static void main(String[] args) {

        Warehouse w = new Warehouse();

        String[] items = {"Pen", "Book", "Bag", "Pencil"};
        int[] quantities = {4, 8, 0, 2};

        for (int i = 0; i < items.length; i++) {

            try {
                w.issue(items[i], quantities[i]);
            }

            catch (OutOfStockException | InvalidQuantityException e) {
                System.out.println(e.getMessage());
            }

            System.out.println();
        }
    }
}