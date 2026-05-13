package app;

public abstract class Media {

    private final String title;
    private final String artist;

    protected Media(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": \"" + title + "\" by " + artist;
    }
}
