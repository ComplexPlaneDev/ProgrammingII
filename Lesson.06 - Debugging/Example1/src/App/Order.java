package App;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderId;
    private String customerName;
    private List<OrderItem> items;
    private boolean vipCustomer;
    private String discountCode;

    public Order(String orderId, String customerName) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.items = new ArrayList<>();
        this.vipCustomer = false;
        this.discountCode = null;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public boolean isVipCustomer() {
        return vipCustomer;
    }

    public void setVipCustomer(boolean vipCustomer) {
        this.vipCustomer = vipCustomer;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public boolean hasDiscountCode() {
        return discountCode != null;
    }

    @Override
    public String toString() {
        return String.format("Order[%s, customer=%s, items=%d, vip=%s]",
            orderId, customerName, items.size(), vipCustomer);
    }
}
