package com.inkspac3.parser;

import com.inkspac3.entity.CustomArray;
import com.inkspac3.exception.CustomArrayException;
import com.inkspac3.factory.ArrFactory;
import com.inkspac3.validator.impl.CustomArrayValidator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ArrayParser {
    private static final Logger log = Logger.getLogger(ArrayParser.class);
    private final CustomArrayValidator validator;
    private final ArrFactory factory;

    public ArrayParser(CustomArrayValidator validator, ArrFactory factory) {
        this.validator = validator;
        this.factory = factory;
    }

    public CustomArray parseToArray(List<String> lines) throws CustomArrayException {
        if (lines == null || lines.isEmpty()) {
            throw new CustomArrayException("No lines to parse");
        }

        List<String> validTokens = new ArrayList<>();

        for (String line : lines) {
            if (line == null) continue;

            String[] parts = line.trim().split("\\s+");
            for (String word : parts) {
                if (isValidString(word)) {
                    validTokens.add(word);
                } else {
                    log.warn("Skipping invalid token: [" + word + "]");
                }
            }
        }

        if (validTokens.isEmpty()) {
            throw new CustomArrayException("No valid tokens found in input");
        }

        validator.validateArrayCreation(validTokens.size());
        CustomArray array = factory.createArray(validTokens.size());

        for (String token : validTokens) {
            array.add(token);
        }

        log.info("Successfully parsed array with " + array.size() + " valid elements");
        return array;
    }

    private boolean isValidString(String str) {
        return str != null && !str.isBlank() && str.matches(".*[a-zA-Zа-яА-Я0-9].*");
    }
}
