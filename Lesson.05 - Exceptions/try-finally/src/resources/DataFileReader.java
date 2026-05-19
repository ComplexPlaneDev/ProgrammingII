package resources;

import exceptions.FileProcessingException;

public class DataFileReader implements AutoCloseable {

    private final String fileName;
    private boolean open;
    private final String[] simulatedLines;

    public DataFileReader(String fileName) throws FileProcessingException {
        this.fileName = fileName;

        if (fileName == null || fileName.isBlank()) {
            throw new FileProcessingException("File name must not be empty.");
        }

        if (fileName.equals("corrupt.dat")) {
            this.simulatedLines = new String[]{"Alice;25", "CORRUPT_LINE", "Charlie;30"};
        } else if (fileName.equals("unstable.dat")) {
            this.simulatedLines = new String[]{"Alice;25", "BAD_LINE", "Charlie;30"};
        } else {
            this.simulatedLines = new String[]{"Alice;25", "Bob;22", "Charlie;30"};
        }

        this.open = true;
        System.out.println("  [DataFileReader] Opened file: " + fileName);
    }

    public String[] readAllLines() throws FileProcessingException {
        if (!open) {
            throw new FileProcessingException("Cannot read — file is already closed.");
        }
        System.out.println("  [DataFileReader] Reading " + simulatedLines.length + " lines from " + fileName);
        return simulatedLines;
    }

    public boolean isOpen() {
        return open;
    }

    @Override
    public void close() throws FileProcessingException {
        if (open) {
            open = false;
            System.out.println("  [DataFileReader] Closing file: " + fileName);

            if (fileName.equals("unstable.dat")) {
                throw new FileProcessingException(
                        "Failed to close file: disk I/O error on " + fileName);
            }

            System.out.println("  [DataFileReader] Closed file: " + fileName);
        } else {
            System.out.println("  [DataFileReader] File was already closed: " + fileName);
        }
    }
}
