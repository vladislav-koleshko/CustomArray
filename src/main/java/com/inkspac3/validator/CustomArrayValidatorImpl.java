package com.inkspac3.validator;

import com.inkspac3.entity.CustomArray;
import com.inkspac3.exception.CustomArrayException;
import org.apache.log4j.Logger;

public class CustomArrayValidatorImpl implements CustomArrayValidator {
    private static final Logger log = Logger.getLogger(CustomArrayValidatorImpl.class);


    @Override
    public boolean validateArrayCreation(int capacity) throws CustomArrayException {
        if (capacity <= 0) {
            log.error("Invalid array capacity " + capacity);
            throw new CustomArrayException("Invalid array capacity " + capacity);
        }
        return true;
    }

    @Override
    public boolean validateArrayElement(int index, int size) throws CustomArrayException {
        if (index < 0 || index >= size) {
            log.error("Invalid index " + index);
            throw new CustomArrayException("Index out of bounds " + index);
        }
        if (size <= 0) {
            log.error("Invalid size " + size);
            throw new CustomArrayException("Invalid size " + size);
        }
        return true;
    }

    @Override
    public boolean validateArray(int size, CustomArray arr) throws CustomArrayException {
        if (arr == null) {
            log.error("Array can't be null ");
            throw new CustomArrayException("Array can't be null!");
        }
        return true;
    }
}
