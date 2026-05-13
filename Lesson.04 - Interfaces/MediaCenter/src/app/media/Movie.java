package app.media;

import app.Media;
import app.Playable;
import app.Streamable;

public class Movie extends Media implements Playable, Streamable {

    private final int durationSeconds;
    private final String streamUrl;

    public Movie(String title, String director, int durationSeconds, String streamUrl) {
        super(title, director);
        this.durationSeconds = durationSeconds;
        this.streamUrl = streamUrl;
    }

    @Override
    public void play() {
        System.out.println("  ▶ Playing movie: \"" + getTitle() + "\" directed by " + getArtist()
                + " [" + durationSeconds + "s]");
    }

    @Override
    public int getDuration() {
        return durationSeconds;
    }

    @Override
    public void stream() {
        System.out.println("  ☁ Streaming movie: \"" + getTitle() + "\" from " + streamUrl);
    }

    @Override
    public String getStreamUrl() {
        return streamUrl;
    }
}
