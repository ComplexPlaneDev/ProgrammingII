package Products;

public class Schokobroetchen implements Product {
    @Override
    public double getPrice() {
        return 2.00;
    }

    @Override
    public String getName() {
        return "Schokobrötchen";
    }
}