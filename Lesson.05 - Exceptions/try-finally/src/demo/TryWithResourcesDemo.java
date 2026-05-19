package demo;

import exceptions.FileProcessingException;
import resources.DataFileReader;
import service.DataProcessor;

public class TryWithResourcesDemo {

    private final DataProcessor processor;

    public TryWithResourcesDemo() {
        this.processor = new DataProcessor();
    }

    public void run(String fileName) {
        System.out.println("=== TryWithResourcesDemo — processing: " + fileName + " ===");

        try (DataFileReader reader = new DataFileReader(fileName)) {

            String[] lines = reader.readAllLines();
            String[] results = processor.processAll(lines);

            System.out.println("  Results:");
            for (String result : results) {
                System.out.println("    -> " + result);
            }

            System.out.println("  (reader still open here: " + reader.isOpen() + ")");

        } catch (FileProcessingException e) {
            System.out.println("  CAUGHT FileProcessingException: " + e.getMessage());

            if (e.getCause() != null) {
                System.out.println("    Caused by: " + e.getCause().getMessage());
            }

            for (Throwable suppressed : e.getSuppressed()) {
                System.out.println("    Suppressed: " + suppressed.getMessage());
            }
        }

        System.out.println();
    }
}
