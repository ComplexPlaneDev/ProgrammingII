package Products.Addons;

public class Chocolate extends Addon {
    @Override
    public double getPrice() {
        return 0.50;
    }

    @Override
    public String getName() {
        return "Chocolate";
    }
}
