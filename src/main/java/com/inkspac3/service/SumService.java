package com.inkspac3.service;

import com.inkspac3.entity.CustomArray;
import com.inkspac3.exception.CustomArrayException;

public interface SumService {
    int calculateSumLength(CustomArray array) throws CustomArrayException;
}
