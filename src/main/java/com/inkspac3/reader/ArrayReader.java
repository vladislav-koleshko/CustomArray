package com.inkspac3.reader;

import com.inkspac3.entity.CustomArray;
import com.inkspac3.exception.CustomArrayException;
import com.inkspac3.factory.ArrFactory;
import com.inkspac3.validator.impl.CustomArrayValidator;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArrayReader {
    private static final Logger log = Logger.getLogger(ArrayReader.class);
    private final CustomArrayValidator validator;
    private final ArrFactory arrFactory;

    public ArrayReader(CustomArrayValidator validator, ArrFactory arrFactory) {
        this.validator = validator;
        this.arrFactory = arrFactory;
    }

    public CustomArray readFromFile(String filePath) throws CustomArrayException {
        if (filePath == null || filePath.isBlank()) {
            throw new CustomArrayException("File path cannot be null or empty");
        }

        log.info("Reading array data from file: " + filePath);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            List<String> validStrings = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                for (String word : parts) {
                    if (isValidString(word)) {
                        validStrings.add(word);
                    } else {
                        log.warn("Skipping invalid token: [" + word + "]");
                    }
                }
            }

            if (validStrings.isEmpty()) {
                throw new CustomArrayException("No valid strings found in file");
            }

            validator.validateArrayCreation(validStrings.size());
            CustomArray array = arrFactory.createArray(validStrings.size());

            for (String word : validStrings) {
                array.add(word);
            }

            log.info("Successfully loaded array from file with " + array.size() + " valid elements");
            return array;

        } catch (IOException e) {
            log.error("Error reading from file: " + filePath, e);
            throw new CustomArrayException("I/O error while reading file: " + e.getMessage());
        }
    }


    private boolean isValidString(String str) {
        if (str == null || str.isBlank()) {
            return false;
        }
        return str.matches(".*[a-zA-Zа-яА-Я0-9].*");
    }
}
