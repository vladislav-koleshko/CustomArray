package com.inkspac3.service;

import com.inkspac3.entity.CustomArray;
import com.inkspac3.exception.CustomArrayException;

public interface MinMaxService {
    int getMin(CustomArray array) throws CustomArrayException;
    int getMax(CustomArray array) throws CustomArrayException;
}
