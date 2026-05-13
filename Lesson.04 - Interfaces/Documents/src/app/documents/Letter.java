package app.documents;

public class Letter extends app.Document {
    private final String recipient;
    private final String message;

    public Letter(String author, String recipient, String message) {
        super(author, "Letter to " + recipient);
        this.recipient = recipient;
        this.message = message;
    }

    public String getRecipient() {
        return recipient;
    }

    @Override
    public String getContent() {
        return String.format(
                "Dear %s,%n%n" +
                "%s%n%n" +
                "Best regards,%n" +
                "%s",
                recipient, message, getAuthor());
    }

    @Override
    public int getPageCount() {
        return 1;
    }
}
