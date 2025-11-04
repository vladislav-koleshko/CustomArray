package com.inkspac3.course.service;

import com.inkspac3.course.entity.CustomArray;
import com.inkspac3.course.exception.CustomArrayException;

public interface SumService {
    int calculateSumLength(CustomArray array) throws CustomArrayException;
}
