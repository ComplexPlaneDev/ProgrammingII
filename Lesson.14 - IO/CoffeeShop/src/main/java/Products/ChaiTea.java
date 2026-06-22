package Products;

public class ChaiTea extends BaseComposableProduct {
    @Override
    public double getPrice() {
        return 2.50;
    }

    @Override
    public String getName() {
        return "Chai Tea";
    }
}
