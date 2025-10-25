package com.inkspac3.service;

import com.inkspac3.entity.CustomArray;
import com.inkspac3.exception.CustomArrayException;

public interface MinMaxService {
    String getMin(CustomArray array) throws CustomArrayException;
    String getMax(CustomArray array) throws CustomArrayException;
}
