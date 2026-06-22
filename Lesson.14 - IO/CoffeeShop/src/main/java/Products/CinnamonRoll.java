package Products;

import java.io.Serializable;

public class CinnamonRoll implements Product, Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public double getPrice() {
        return 5.00;
    }

    @Override
    public String getName() {
        return "Cinnamon Roll";
    }
}