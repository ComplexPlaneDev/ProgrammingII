package Products;

public class GreenTea extends BaseComposableProduct {
    @Override
    public double getPrice() {
        return 2.00;
    }

    @Override
    public String getName() {
        return "Green Tea";
    }
}
