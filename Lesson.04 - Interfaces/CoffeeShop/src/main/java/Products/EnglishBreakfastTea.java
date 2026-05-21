package Products;

public class EnglishBreakfastTea extends BaseComposableProduct {

    @Override
    public double getPrice() {
        return 2.50;
    }

    @Override
    public String getName() {
        return "English Breakfast";
    }
}
