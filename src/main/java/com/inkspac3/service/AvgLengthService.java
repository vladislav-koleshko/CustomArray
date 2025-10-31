package com.inkspac3.service;

import com.inkspac3.entity.CustomArray;
import com.inkspac3.exception.CustomArrayException;

public interface AvgLengthService {
    int calculateAvgLength(CustomArray array) throws CustomArrayException;
}
