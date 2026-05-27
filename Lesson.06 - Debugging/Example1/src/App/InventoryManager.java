package App;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    private Map<String, Product> products;

    public InventoryManager() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    public Product getProduct(String productId) {
        return products.get(productId);
    }

    public boolean isProductAvailable(String productId, int quantity) {
        Product product = products.get(productId);
        if (product == null) {
            return false;
        }
        return product.getStockQuantity() >= quantity;
    }

    public void reserveProduct(String productId, int quantity) {
        Product product = products.get(productId);
        if (product == null) {
            throw new IllegalArgumentException("Product not found: " + productId);
        }
        product.reduceStock(quantity);
    }

    public double getProductPrice(String productId) {
        Product product = products.get(productId);
        if (product == null) {
            throw new IllegalArgumentException("Product not found: " + productId);
        }
        return product.getPrice();
    }

    public double calculateItemTotal(OrderItem item) {
        double price = getProductPrice(item.getProductId());
        return price * item.getQuantity();
    }
}
