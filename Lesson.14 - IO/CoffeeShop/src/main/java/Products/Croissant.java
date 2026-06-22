package Products;

import java.io.Serializable;

public class Croissant implements Product, Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public double getPrice() {
        return 1.00;
    }

    @Override
    public String getName() {
        return "Croissant";
    }
}