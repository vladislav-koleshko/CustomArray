package com.inkspac3.course.reader;

import com.inkspac3.course.exception.CustomArrayException;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CustomArrayReader {
    private static final Logger log = Logger.getLogger(CustomArrayReader.class);

    public List<String> readLines(String filePath) throws CustomArrayException, IOException {
        if (filePath == null || filePath.isBlank()) {
            throw new CustomArrayException("File path cannot be null or empty");
        }

        log.info("Reading file: " + filePath);
        List<String> lines = Files.readAllLines(Path.of(filePath));
        log.info("Read " + lines.size() + " lines from file");
        return lines;
    }
}
