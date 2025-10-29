package com.inkspac3.parser;

import com.inkspac3.entity.CustomArray;
import com.inkspac3.exception.CustomArrayException;
import com.inkspac3.factory.ArrFactory;
import com.inkspac3.validator.CustomArrayValidator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ArrayParser {
    private static final Logger log = Logger.getLogger(ArrayParser.class);
    private final CustomArrayValidator validator;
    private final ArrFactory factory;
    private static final String VALID_STRING_REGEX = ".*[a-zA-Zа-яА-Я0-9].*";
    private static final String SPACE_DELIMITER = "\\s+";


    public ArrayParser(CustomArrayValidator validator, ArrFactory factory) {
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
