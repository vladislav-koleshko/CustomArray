package com.inkspac3.validator.impl;

import com.inkspac3.entity.CustomArray;
import com.inkspac3.exception.CustomArrayException;

public interface CustomArrayValidator {
    boolean validateArrayCreation(int capacity) throws CustomArrayException;
    boolean validateArrayElement(int index, int size) throws CustomArrayException;
    boolean validateArray(int size, CustomArray arr) throws CustomArrayException;
}
