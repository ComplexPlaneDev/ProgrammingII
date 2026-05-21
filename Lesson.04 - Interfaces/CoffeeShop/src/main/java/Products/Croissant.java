package Products;

public class Croissant implements Product {
    @Override
    public double getPrice() {
        return 1.00;
    }

    @Override
    public String getName() {
        return "Croissant";
    }
}