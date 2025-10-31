package com.inkspac3.service;

import com.inkspac3.entity.CustomArray;
import com.inkspac3.exception.CustomArrayException;

public interface CountOfElemService {
    int calculateCountOfElem(CustomArray array) throws CustomArrayException;
}
