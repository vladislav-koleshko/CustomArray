package com.inkspac3.course.parser;

import com.inkspac3.course.entity.CustomArray;
import com.inkspac3.course.exception.CustomArrayException;
import com.inkspac3.course.factory.CustomArrayFactory;
import com.inkspac3.course.validator.CustomArrayValidator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayParser {
    private static final Logger log = Logger.getLogger(CustomArrayParser.class);
    private final CustomArrayValidator validator;
    private final CustomArrayFactory factory;
    private static final String VALID_STRING_REGEX = ".*[a-zA-Zа-яА-Я0-9].*";
    private static final String SPACE_DELIMITER = "\\s+";


    public CustomArrayParser(CustomArrayValidator validator, CustomArrayFactory factory) {
        this.validator = validator;
        this.factory = factory;
    }

    public CustomArray parseToArray(List<String> lines) throws CustomArrayException {
        if (lines == null || lines.isEmpty()) {
            log.error("Empty array line");
            throw new CustomArrayException("No lines to parse");
        }

        List<String> validStrings = new ArrayList<>();

        for (String line : lines) {
            if (line == null) continue;

            String[] parts = line.trim().split(SPACE_DELIMITER);
            for (String word : parts) {
                if (isValidString(word)) {
                    validStrings.add(word);
                } else {
                    log.warn("Skipping invalid token: [" + word + "]");
                }
            }
        }

        if (validStrings.isEmpty()) {
            log.error("No valid strings found");
            throw new CustomArrayException("No valid strings found");
        }

        validator.validateArrayCreation(validStrings.size());
        CustomArray array = factory.createArray(validStrings.size());

        for (String elem : validStrings) {
            array.add(elem);
        }

        log.info("Successfully parsed array with " + array.size() + " valid elements");
        return array;
    }

    private boolean isValidString(String str) {
        return str != null && !str.isBlank() && str.matches(VALID_STRING_REGEX);
    }
}
