package Products.Addons;

public class Vanilla extends Addon {
    @Override
    public double getPrice() {
        return 0.50;
    }

    @Override
    public String getName() {
        return "Vanilla";
    }
}
