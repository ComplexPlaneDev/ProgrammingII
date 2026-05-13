import java.util.List;

import app.Downloadable;
import app.Playable;
import app.Streamable;
import app.consumers.DownloadManager;
import app.consumers.MusicPlayer;
import app.consumers.StreamingDevice;
import app.media.Movie;
import app.media.Podcast;
import app.media.Song;

public class App {

    public static void main(String[] args) {

        Song song       = new Song("Bohemian Rhapsody", "Queen", 354, 8);
        Movie movie     = new Movie("Inception", "C. Nolan", 8880, "https://stream.example.com/inception");
        Podcast podcast = new Podcast("Tech Talk", "J. Doe", 42, 2700, 45, "https://stream.example.com/techtalk/42");

        MusicPlayer player = new MusicPlayer("MyPlayer");
        List<Playable> playlist = List.of(song, movie, podcast);
        player.playAll(playlist);

        DownloadManager dm = new DownloadManager("/home/user/downloads");
        List<Downloadable> downloadable = List.of(song, podcast);
        dm.downloadAll(downloadable);

        StreamingDevice tv = new StreamingDevice("Living Room TV");
        List<Streamable> streamable = List.of(movie, podcast);
        tv.streamAll(streamable);
    }
}
