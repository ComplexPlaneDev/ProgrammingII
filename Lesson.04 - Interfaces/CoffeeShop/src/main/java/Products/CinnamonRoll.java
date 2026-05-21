package Products;

public class CinnamonRoll implements Product {
    @Override
    public double getPrice() {
        return 5.00;
    }

    @Override
    public String getName() {
        return "Cinnamon Roll";
    }
}