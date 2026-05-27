package App;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Order Processing System ===\n");

        InventoryManager inventory = new InventoryManager();
        inventory.addProduct(new Product("P001", "Laptop", 999.99, 10));
        inventory.addProduct(new Product("P002", "Mouse", 29.99, 50));
        inventory.addProduct(new Product("P003", "Keyboard", 79.99, 30));
        inventory.addProduct(new Product("P004", "Monitor", 299.99, 15));
        inventory.addProduct(new Product("P005", "USB Cable", 9.99, 100));

        OrderProcessor processor = new OrderProcessor(inventory);

        List<Order> orders = createSampleOrders();

        System.out.println("Processing " + orders.size() + " orders...\n");

        for (Order order : orders) {
            try {
                OrderResult result = processor.processOrder(order);
                System.out.println("Order " + order.getOrderId() + " processed successfully!");
                System.out.println("  Total: $" + String.format("%.2f", result.getFinalPrice()));
                System.out.println("  Discount applied: " + result.getDiscountPercentage() + "%\n");
            } catch (Exception e) {
                System.err.println("Error processing order " + order.getOrderId() + ": " + e.getMessage());
                e.printStackTrace();
            }
        }

        System.out.println("=== Processing Complete ===");
    }

    private static List<Order> createSampleOrders() {
        List<Order> orders = new ArrayList<>();

        Order order1 = new Order("ORD-001", "Alice");
        order1.addItem(new OrderItem("P001", 1));  // 1 Laptop
        order1.addItem(new OrderItem("P002", 2));  // 2 Mice
        orders.add(order1);

        Order order2 = new Order("ORD-002", "Bob");
        order2.addItem(new OrderItem("P004", 2));  // 2 Monitors
        order2.addItem(new OrderItem("P003", 1));  // 1 Keyboard
        order2.addItem(new OrderItem("P005", 5));  // 5 USB Cables
        orders.add(order2);

        Order order3 = new Order("ORD-003", "Charlie");
        order3.setVipCustomer(true);
        order3.addItem(new OrderItem("P001", 2));  // 2 Laptops
        order3.addItem(new OrderItem("P004", 1));  // 1 Monitor
        orders.add(order3);

        Order order4 = new Order("ORD-004", "Diana");
        order4.addItem(new OrderItem("P002", 3));  // 3 Mice
        order4.addItem(new OrderItem("P005", 10)); // 10 USB Cables
        order4.setDiscountCode("");  // Empty discount code - potential bug trigger!
        orders.add(order4);

        Order order5 = new Order("ORD-005", "Eve");
        order5.addItem(new OrderItem("P003", 2));  // 2 Keyboards
        orders.add(order5);

        return orders;
    }
}
