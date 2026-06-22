package Products;

public class LatteMacchiato extends BaseComposableProduct {
    @Override
    public double getPrice() {
        return 3.50;
    }

    @Override
    public String getName() {
        return "Latte Macchiato";
    }
}
