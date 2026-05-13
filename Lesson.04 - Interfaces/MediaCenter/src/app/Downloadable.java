package app;

public interface Downloadable {

    void download(String targetPath);

    int getFileSize();
}
