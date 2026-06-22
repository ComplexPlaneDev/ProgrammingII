package Products;

public class Cappuccino extends BaseComposableProduct {
    @Override
    public double getPrice() {
        return 3.00;
    }

    @Override
    public String getName() {
        return "Cappuccino";
    }
}
