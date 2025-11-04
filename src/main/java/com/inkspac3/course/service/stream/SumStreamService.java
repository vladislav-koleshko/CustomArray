package com.inkspac3.course.service.stream;

import com.inkspac3.course.entity.CustomArray;
import com.inkspac3.course.exception.CustomArrayException;

public interface SumStreamService {
    int sumOfLengths(CustomArray array) throws CustomArrayException;
}
