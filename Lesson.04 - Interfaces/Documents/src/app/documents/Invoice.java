package app.documents;

public class Invoice extends app.Document {

    private final String customerName;
    private final double amount;

    public Invoice(String author, String customerName, double amount) {
        super(author, "Invoice for " + customerName);
        this.customerName = customerName;
        this.amount = amount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String getContent() {
        return String.format(
                "INVOICE%n" +
                "Customer: %s%n" +
                "Amount:   %.2f EUR%n" +
                "Issued by: %s",
                customerName, amount, getAuthor());
    }

    @Override
    public int getPageCount() {
        return 1;
    }
}
