package com.inkspac3.course.service;

import com.inkspac3.course.entity.CustomArray;
import com.inkspac3.course.exception.CustomArrayException;

public interface AvgLengthService {
    int calculateAvgLength(CustomArray array) throws CustomArrayException;
}
