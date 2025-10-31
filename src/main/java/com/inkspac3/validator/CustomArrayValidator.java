package com.inkspac3.validator;

import com.inkspac3.entity.CustomArray;
import com.inkspac3.exception.CustomArrayException;

public interface CustomArrayValidator {
    boolean validateArrayCreation(int capacity);
    boolean validateArrayElement(int index, int size);
    boolean validateArray(CustomArray arr);
}
