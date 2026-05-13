package app.consumers;

import java.util.List;

import app.Playable;

public class MusicPlayer {

    private final String name;

    public MusicPlayer(String name) {
        this.name = name;
    }

    public void playAll(List<Playable> playlist) {
        System.out.println("[" + name + "] Playing " + playlist.size() + " items:");
        int totalDuration = 0;
        for (Playable item : playlist) {
            item.play();
            totalDuration += item.getDuration();
        }
        System.out.println("[" + name + "] Total duration: " + totalDuration + "s\n");
    }
}
