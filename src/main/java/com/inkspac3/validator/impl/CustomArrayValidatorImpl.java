package com.inkspac3.validator.impl;

import com.inkspac3.entity.CustomArray;
import com.inkspac3.exception.CustomArrayException;
import com.inkspac3.validator.CustomArrayValidator;
import org.apache.log4j.Logger;

public class CustomArrayValidatorImpl implements CustomArrayValidator {
    private static final Logger log = Logger.getLogger(CustomArrayValidatorImpl.class);


    @Override
    public boolean validateArrayCreation(int capacity){
        if (capacity <= 0) {
            log.error("Invalid array capacity " + capacity);
            return false;
        }
        return true;
    }

    @Override
    public boolean validateArrayElement(int index, int size){
        if (index < 0 || index >= size) {
            log.error("Invalid index " + index);
            return false;
        }
        return true;
    }

    @Override
    public boolean validateArray(CustomArray arr){
        if (arr == null) {
            log.error("Array can't be null");
            return false;
        }
        return true;
    }
}
