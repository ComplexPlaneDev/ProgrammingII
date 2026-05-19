package demo;

import exceptions.FileProcessingException;
import resources.DataFileReader;
import service.DataProcessor;

public class TryFinallyDemo {

    private final DataProcessor processor;

    public TryFinallyDemo() {
        this.processor = new DataProcessor();
    }

    public void run(String fileName) {
        System.out.println("=== TryFinallyDemo — processing: " + fileName + " ===");

        DataFileReader reader = null;

        try {
            reader = new DataFileReader(fileName);
            String[] lines = reader.readAllLines();
            String[] results = processor.processAll(lines);

            System.out.println("  Results:");
            for (String result : results) {
                System.out.println("    -> " + result);
            }

        } catch (FileProcessingException e) {
            System.out.println("  CAUGHT FileProcessingException: " + e.getMessage());

            if (e.getCause() != null) {
                System.out.println("    Caused by: " + e.getCause().getMessage());
            }

        } finally {
            System.out.println("  [finally] Cleaning up...");

            if (reader != null) {
                try {
                    reader.close();
                } catch (FileProcessingException e) {
                    System.out.println("  [finally] Error while closing: " + e.getMessage());
                }
            } else {
                System.out.println("  [finally] Reader was never opened — nothing to close.");
            }
        }

        System.out.println();
    }
}
