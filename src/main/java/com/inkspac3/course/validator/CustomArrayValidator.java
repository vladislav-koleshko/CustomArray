package com.inkspac3.course.validator;

import com.inkspac3.course.entity.CustomArray;

public interface CustomArrayValidator {
    boolean validateArrayCreation(int capacity);
    boolean validateArrayElement(int index, int size);
    boolean validateArray(CustomArray arr);
}
