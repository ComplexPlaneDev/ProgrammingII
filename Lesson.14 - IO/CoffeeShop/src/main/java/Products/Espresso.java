package Products;

public class Espresso extends BaseComposableProduct {
    @Override
    public double getPrice() {
        return 2.00;
    }

    @Override
    public String getName() {
        return "Espresso";
    }
}
