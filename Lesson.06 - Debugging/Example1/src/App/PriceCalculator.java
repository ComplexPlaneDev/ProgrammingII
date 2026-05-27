package App;

public class PriceCalculator {
    private InventoryManager inventory;
    private DiscountCalculator discountCalculator;

    public PriceCalculator(InventoryManager inventory) {
        this.inventory = inventory;
        this.discountCalculator = new DiscountCalculator();
    }

    public PriceBreakdown calculateOrderPrice(Order order) {
        double subtotal = calculateSubtotal(order);

        int discountPercentage = calculateDiscount(order, subtotal);

        double finalPrice = applyDiscount(subtotal, discountPercentage);

        return new PriceBreakdown(subtotal, discountPercentage, finalPrice);
    }

    private double calculateSubtotal(Order order) {
        double subtotal = 0.0;
        for (OrderItem item : order.getItems()) {
            subtotal += inventory.calculateItemTotal(item);
        }
        return subtotal;
    }

    private int calculateDiscount(Order order, double subtotal) {
        return discountCalculator.calculateDiscountPercentage(order, subtotal);
    }

    private double applyDiscount(double subtotal, int discountPercentage) {
        return discountCalculator.applyDiscount(subtotal, discountPercentage);
    }

    public static class PriceBreakdown {
        private double subtotal;
        private int discountPercentage;
        private double finalPrice;

        public PriceBreakdown(double subtotal, int discountPercentage, double finalPrice) {
            this.subtotal = subtotal;
            this.discountPercentage = discountPercentage;
            this.finalPrice = finalPrice;
        }

        public double getSubtotal() {
            return subtotal;
        }

        public int getDiscountPercentage() {
            return discountPercentage;
        }

        public double getFinalPrice() {
            return finalPrice;
        }
    }
}
