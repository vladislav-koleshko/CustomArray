package com.inkspac3.reader;

import org.apache.log4j.Logger;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ArrayReader {
    private static final Logger log = Logger.getLogger(ArrayReader.class);

    public List<String> readLines(String filePath) throws IOException {
        if (filePath == null || filePath.isBlank()) {
            throw new IOException("File path cannot be null or empty");
        }

        log.info("Reading file: " + filePath);
        List<String> lines = Files.readAllLines(Path.of(filePath));
        log.info("Read " + lines.size() + " lines from file");
        return lines;
    }
}
