package Orders;

import java.util.ArrayList;
import java.util.List;

import Products.ComposableProduct;
import Products.Product;
import Products.Addons.Addon;

public class Receipt {
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

    @Override
    public String toString() {
        String out = "";

        for (Item i : items) {
            out += "-----\n";
            out += i.product.getName() + ": " + Receipt.toEuro(i.product.getPrice()) + "\n";

            if (i.product instanceof ComposableProduct) {
                ComposableProduct cp = (ComposableProduct) i.product;

                for (Addon a : cp.addons()) {
                    out += "\t" + a.getName() + ": +" + Receipt.toEuro(a.getPrice()) + "\n";
                }
            }

            out += "\n  x" + String.valueOf(i.quantity) + ": " + Receipt.toEuro(computeProductPrice(i.product) * i.quantity) + "\n";
            out += "-----\n\n";
        }

        return out + "TOTAL: " + String.format("%.2f", getTotal()) + "€";
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
