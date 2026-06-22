package Orders;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Products.ComposableProduct;
import Products.Product;
import Products.Addons.Addon;

public class Receipt implements Serializable {
    private static final long serialVersionUID = 1L;

    private final List<Item> items = new ArrayList<Item>();

    public void addProduct(Product p, int q) {
        items.add(new Item(p, q));
    }

    public double getTotal() {
        double total = 0.0;

        for (Item i : items) {
            total += i.product.getPrice() * i.quantity;

            if (i.product instanceof ComposableProduct) {
                ComposableProduct cp = (ComposableProduct) i.product;

                for (Addon a : cp.addons()) {
                    total += a.getPrice() * i.quantity;
                }
            }
        }

        return total;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public String toString() {
        String out = "";

        for (Item i : items) {
            out += "-----\n" + i.toString() + "-----\n\n";
        }

        return out + "TOTAL: " + toEuro(getTotal());
    }

    private static String toEuro(double value) {
        return String.format("%.2f", value) + "€";
    }
}
