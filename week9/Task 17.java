import java.util.*;

class Order {
    int orderId;
    String productName;
    int quantity;
    int availableStock;

    Order(int orderId, String productName, int quantity, int availableStock) {
        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
        this.availableStock = availableStock;
    }

    void processOrder() throws Exception {
        if (quantity > availableStock) {
            throw new Exception("Insufficient stock");
        }
        System.out.println("Order " + orderId + " processed successfully");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int orderId = sc.nextInt();
            String productName = sc.next();
            int quantity = sc.nextInt();
            int availableStock = sc.nextInt();

            Order order = new Order(orderId, productName, quantity, availableStock);

            try {
                order.processOrder();
            } 
            catch (Exception e) {
                System.out.println("Order " + orderId + " failed: " + e.getMessage());
            }
        }

        sc.close();
    }
}