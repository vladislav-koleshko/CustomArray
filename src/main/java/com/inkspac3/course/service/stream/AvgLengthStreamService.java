package com.inkspac3.course.service.stream;

import com.inkspac3.course.entity.CustomArray;
import com.inkspac3.course.exception.CustomArrayException;

public interface AvgLengthStreamService {
    double calculateAvgLength(CustomArray customArray) throws CustomArrayException;
}
