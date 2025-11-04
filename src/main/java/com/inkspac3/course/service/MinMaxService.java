package com.inkspac3.course.service;

import com.inkspac3.course.entity.CustomArray;
import com.inkspac3.course.exception.CustomArrayException;

public interface MinMaxService {
    int getMin(CustomArray array) throws CustomArrayException;
    int getMax(CustomArray array) throws CustomArrayException;
}
