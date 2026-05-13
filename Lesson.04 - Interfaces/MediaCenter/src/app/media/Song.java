package app.media;

import app.Downloadable;
import app.Media;
import app.Playable;

public class Song extends Media implements Playable, Downloadable {

    private final int durationSeconds;
    private final int fileSizeMB;

    public Song(String title, String artist, int durationSeconds, int fileSizeMB) {
        super(title, artist);
        this.durationSeconds = durationSeconds;
        this.fileSizeMB = fileSizeMB;
    }

    @Override
    public void play() {
        System.out.println("  ♪ Playing song: \"" + getTitle() + "\" by " + getArtist()
                + " [" + durationSeconds + "s]");
    }

    @Override
    public int getDuration() {
        return durationSeconds;
    }

    @Override
    public void download(String targetPath) {
        System.out.println("  ↓ Downloading song \"" + getTitle() + "\" (" + fileSizeMB
                + " MB) to " + targetPath);
    }

    @Override
    public int getFileSize() {
        return fileSizeMB;
    }
}
