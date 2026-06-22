package Products;

import java.io.Serializable;

public class Schokobroetchen implements Product, Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public double getPrice() {
        return 2.00;
    }

    @Override
    public String getName() {
        return "Schokobrötchen";
    }
}