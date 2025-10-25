package com.inkspac3.factory;

import com.inkspac3.entity.CustomArray;
import com.inkspac3.exception.CustomArrayException;
import com.inkspac3.validator.CustomArrayValidator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ArrFactory {
    private static final Logger log = LogManager.getLogger(ArrFactory.class);
    private CustomArrayValidator validator;

    public ArrFactory() {}
    public ArrFactory(final CustomArrayValidator validator) {
        this.validator = validator;
    }

    public CustomArray createArray(int capacity) throws CustomArrayException {
        if (!validator.validateArrayCreation(capacity)) {
            throw new CustomArrayException("Array can't be created");
        }
        return new CustomArray(capacity, validator);
    }
}
