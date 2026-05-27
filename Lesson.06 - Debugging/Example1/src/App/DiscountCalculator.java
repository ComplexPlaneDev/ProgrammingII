package App;

public class DiscountCalculator {

    private static final double TIER1_THRESHOLD = 500.0;
    private static final double TIER2_THRESHOLD = 1000.0;
    private static final double TIER3_THRESHOLD = 2000.0;

    private static final int TIER1_DISCOUNT = 5;
    private static final int TIER2_DISCOUNT = 10;
    private static final int TIER3_DISCOUNT = 15;
    private static final int VIP_BONUS = 5;

    public int calculateDiscountPercentage(Order order, double subtotal) {
        int discount = 0;

        discount = calculateTierDiscount(subtotal);

        if (order.isVipCustomer()) {
            discount = applyVipBonus(discount);
        }

        if (order.hasDiscountCode()) {
            discount = applyDiscountCode(order.getDiscountCode(), discount);
        }

        return discount;
    }

    private int calculateTierDiscount(double subtotal) {
        if (subtotal >= TIER3_THRESHOLD) {
            return TIER3_DISCOUNT;
        } else if (subtotal >= TIER2_THRESHOLD) {
            return TIER2_DISCOUNT;
        } else if (subtotal >= TIER1_THRESHOLD) {
            return TIER1_DISCOUNT;
        }
        return 0;
    }

    private int applyVipBonus(int currentDiscount) {
        return currentDiscount + VIP_BONUS;
    }

    private int applyDiscountCode(String code, int currentDiscount) {
        int codeDiscount = parseDiscountCode(code);
        return currentDiscount + codeDiscount;
    }

    private int parseDiscountCode(String code) {
        char firstChar = code.charAt(0);

        if (firstChar == 'S') {
            if (code.equals("SAVE10")) {
                return 10;
            } else if (code.equals("SAVE20")) {
                return 20;
            } else if (code.equals("SPECIAL")) {
                return 25;
            }
        }

        return 0;
    }

    public double applyDiscount(double subtotal, int discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Invalid discount percentage: " + discountPercentage);
        }
        double discountAmount = subtotal * (discountPercentage / 100.0);
        return subtotal - discountAmount;
    }
}
