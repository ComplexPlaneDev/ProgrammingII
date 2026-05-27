package App;

public class OrderResult {
    private String orderId;
    private double subtotal;
    private double finalPrice;
    private int discountPercentage;
    private boolean success;

    public OrderResult(String orderId) {
        this.orderId = orderId;
        this.success = false;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
