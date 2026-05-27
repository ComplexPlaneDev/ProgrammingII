package App;

public class OrderValidator {
    private InventoryManager inventory;

    public OrderValidator(InventoryManager inventory) {
        this.inventory = inventory;
    }

    public ValidationResult validateOrder(Order order) {
        if (order.getItems().isEmpty()) {
            return new ValidationResult(false, "Order has no items");
        }

        for (OrderItem item : order.getItems()) {
            ValidationResult itemResult = validateItem(item);
            if (!itemResult.isValid()) {
                return itemResult;
            }
        }

        if (order.getCustomerName() == null || order.getCustomerName().trim().isEmpty()) {
            return new ValidationResult(false, "Customer name is required");
        }

        return new ValidationResult(true, "Order is valid");
    }

    private ValidationResult validateItem(OrderItem item) {
        if (inventory.getProduct(item.getProductId()) == null) {
            return new ValidationResult(false, "Product not found: " + item.getProductId());
        }

        if (item.getQuantity() <= 0) {
            return new ValidationResult(false, "Invalid quantity for product: " + item.getProductId());
        }

        if (!inventory.isProductAvailable(item.getProductId(), item.getQuantity())) {
            return new ValidationResult(false, "Insufficient stock for product: " + item.getProductId());
        }

        return new ValidationResult(true, "Item is valid");
    }
}
