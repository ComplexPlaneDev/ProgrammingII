package app.media;

import app.Downloadable;
import app.Media;
import app.Playable;
import app.Streamable;

public class Podcast extends Media implements Playable, Downloadable, Streamable {

    private final int episodeNumber;
    private final int durationSeconds;
    private final int fileSizeMB;
    private final String streamUrl;

    public Podcast(String title, String host, int episodeNumber,
                   int durationSeconds, int fileSizeMB, String streamUrl) {
        super(title, host);
        this.episodeNumber = episodeNumber;
        this.durationSeconds = durationSeconds;
        this.fileSizeMB = fileSizeMB;
        this.streamUrl = streamUrl;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    @Override
    public void play() {
        System.out.println("  🎙 Playing podcast: \"" + getTitle() + "\" ep." + episodeNumber
                + " by " + getArtist() + " [" + durationSeconds + "s]");
    }

    @Override
    public int getDuration() {
        return durationSeconds;
    }

    @Override
    public void download(String targetPath) {
        System.out.println("  ↓ Downloading podcast ep." + episodeNumber + " \"" + getTitle()
                + "\" (" + fileSizeMB + " MB) to " + targetPath);
    }

    @Override
    public int getFileSize() {
        return fileSizeMB;
    }

    @Override
    public void stream() {
        System.out.println("  ☁ Streaming podcast: \"" + getTitle() + "\" ep." + episodeNumber
                + " from " + streamUrl);
    }

    @Override
    public String getStreamUrl() {
        return streamUrl;
    }
}
