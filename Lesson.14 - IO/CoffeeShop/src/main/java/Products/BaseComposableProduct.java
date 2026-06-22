package Products;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Products.Addons.Addon;

public abstract class BaseComposableProduct implements ComposableProduct, Serializable {
    private static final long serialVersionUID = 1L;
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
