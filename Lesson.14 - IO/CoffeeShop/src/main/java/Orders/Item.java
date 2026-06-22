package Orders;

import java.io.Serializable;

import Products.ComposableProduct;
import Products.Product;
import Products.Addons.Addon;

public class Item implements Serializable {
    private static final long serialVersionUID = 1L;

    public final Product product;
    public final int quantity;

    public Item(Product p, int q) {
        product = p;
        quantity = q;
    }

    @Override
    public String toString() {
        String out = product.getName() + ": " + toEuro(product.getPrice()) + "\n";

        if (product instanceof ComposableProduct) {
            ComposableProduct cp = (ComposableProduct) product;

            for (Addon a : cp.addons()) {
                out += "\t" + a.getName() + ": +" + toEuro(a.getPrice()) + "\n";
            }
        }

        out += "\n  x" + String.valueOf(quantity) + ": " + toEuro(computeProductPrice(product) * quantity) + "\n";

        return out;
    }

    private double computeProductPrice(Product p) {
        double out = p.getPrice();

        if (p instanceof ComposableProduct) {
            ComposableProduct cp = (ComposableProduct) p;

            for (Addon a : cp.addons()) {
                out += a.getPrice();
            }
        }

        return out;
    }

    private static String toEuro(double value) {
        return String.format("%.2f", value) + "€";
    }
}
