package app.documents;

public class Report extends app.Document {

    private final String topic;
    private final String body;

    public Report(String author, String topic, String body) {
        super(author, "Report: " + topic);
        this.topic = topic;
        this.body = body;
    }

    public String getTopic() {
        return topic;
    }

    @Override
    public String getContent() {
        return String.format(
                "REPORT: %s%n" +
                "Author: %s%n" +
                "----%n" +
                "%s",
                topic, getAuthor(), body);
    }

    @Override
    public int getPageCount() {
        // Simulate: 1 page per 500 characters, minimum 1
        return Math.max(1, body.length() / 500 + 1);
    }
}
