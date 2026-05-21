package Orders;

import Products.Product;

public class Item {
    public final Product product;
    public final int quantity;

    public Item(Product p, int q) {
        product = p;
        quantity = q;
    }
}
