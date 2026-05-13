package app.consumers;

import java.util.List;

import app.Downloadable;

public class DownloadManager {

    private final String downloadFolder;

    public DownloadManager(String downloadFolder) {
        this.downloadFolder = downloadFolder;
    }

    public void downloadAll(List<Downloadable> items) {
        System.out.println("[DownloadManager → " + downloadFolder + "] Downloading "
                + items.size() + " items:");
        double totalSize = 0;
        for (Downloadable item : items) {
            item.download(downloadFolder);
            totalSize += item.getFileSize();
        }
        System.out.printf("[DownloadManager] Total size: %.1f MB%n%n", totalSize);
    }
}
