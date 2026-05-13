package app.consumers;

import java.util.List;

import app.Streamable;

public class StreamingDevice {

    private final String deviceName;

    public StreamingDevice(String deviceName) {
        this.deviceName = deviceName;
    }

    public void streamAll(List<Streamable> items) {
        System.out.println("[" + deviceName + "] Streaming " + items.size() + " items:");
        for (Streamable item : items) {
            System.out.println("  URL: " + item.getStreamUrl());
            item.stream();
        }
        System.out.println("[" + deviceName + "] Stream session complete.\n");
    }
}
