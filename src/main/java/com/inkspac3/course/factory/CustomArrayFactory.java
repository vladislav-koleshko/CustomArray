package com.inkspac3.course.factory;

import com.inkspac3.course.entity.CustomArray;
import com.inkspac3.course.exception.CustomArrayException;
import com.inkspac3.course.util.CustomArrayIdGenerator;
import com.inkspac3.course.validator.CustomArrayValidator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class CustomArrayFactory {
    private static final Logger log = LogManager.getLogger(CustomArrayFactory.class);
    private CustomArrayValidator validator;

    public CustomArrayFactory(final CustomArrayValidator validator) {
        this.validator = validator;
    }

    public CustomArray createArray(int capacity) throws CustomArrayException {
        long id = CustomArrayIdGenerator.generateId();
        if (!validator.validateArrayCreation(capacity)) {
            log.error("Invalid array capacity: " + capacity);
            throw new CustomArrayException("Array can't be created");
        }
        return new CustomArray(id, capacity);
    }
}
