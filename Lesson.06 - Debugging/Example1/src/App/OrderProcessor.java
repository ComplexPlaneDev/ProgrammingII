package App;

public class OrderProcessor {
    private InventoryManager inventory;
    private PriceCalculator priceCalculator;
    private OrderValidator validator;

    public OrderProcessor(InventoryManager inventory) {
        this.inventory = inventory;
        this.priceCalculator = new PriceCalculator(inventory);
        this.validator = new OrderValidator(inventory);
    }

    public OrderResult processOrder(Order order) {
        System.out.println("Processing order: " + order.getOrderId());

        ValidationResult validation = validator.validateOrder(order);
        if (!validation.isValid()) {
            throw new IllegalStateException("Order validation failed: " + validation.getMessage());
        }

        PriceCalculator.PriceBreakdown pricing = priceCalculator.calculateOrderPrice(order);

        reserveInventory(order);

        OrderResult result = new OrderResult(order.getOrderId());
        result.setSubtotal(pricing.getSubtotal());
        result.setFinalPrice(pricing.getFinalPrice());
        result.setDiscountPercentage(pricing.getDiscountPercentage());
        result.setSuccess(true);

        return result;
    }

    private void reserveInventory(Order order) {
        for (OrderItem item : order.getItems()) {
            inventory.reserveProduct(item.getProductId(), item.getQuantity());
        }
    }
}
