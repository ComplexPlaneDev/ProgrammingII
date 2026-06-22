package Products;

import java.util.List;

import Products.Addons.Addon;

public interface ComposableProduct extends Product {
    void addOnTop(Addon a);

    List<Addon> addons();
}
