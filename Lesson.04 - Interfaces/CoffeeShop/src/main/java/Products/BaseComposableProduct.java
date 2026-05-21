package Products;

import java.util.ArrayList;
import java.util.List;

import Products.Addons.Addon;

public abstract class BaseComposableProduct implements ComposableProduct {
    private List<Addon> addOns = new ArrayList<Addon>();

    @Override
    public void addOnTop(Addon a) {
        addOns.add(a);
    }

    @Override
    public List<Addon> addons() {
        return addOns;
    }
}
