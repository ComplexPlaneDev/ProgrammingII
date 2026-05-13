package app;

public abstract class Document implements Printable {

    private final String author;
    private final String title;

    protected Document(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
