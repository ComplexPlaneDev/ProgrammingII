package service;

import exceptions.FileProcessingException;
import exceptions.InvalidDataException;

public class DataProcessor {

    public String parseLine(String line) {
        if (line == null || !line.contains(";")) {
            throw new InvalidDataException(
                    "Bad format — expected 'Name;Age' but got: \"" + line + "\"");
        }

        String[] parts = line.split(";", 2);
        String name = parts[0].trim();
        String ageText = parts[1].trim();

        try {
            int age = Integer.parseInt(ageText);
            return name + " (age " + age + ")";
        } catch (NumberFormatException e) {
            throw new InvalidDataException(
                    "Age is not a number in line: \"" + line + "\"", e);
        }
    }

    public String[] processAll(String[] lines) throws FileProcessingException {
        String[] results = new String[lines.length];

        for (int i = 0; i < lines.length; i++) {
            try {
                results[i] = parseLine(lines[i]);
            } catch (InvalidDataException e) {
                throw new FileProcessingException(
                        "Processing failed at line " + (i + 1), e);
            }
        }

        return results;
    }
}
