package com.inkspac3.course.service;

import com.inkspac3.course.entity.CustomArray;
import com.inkspac3.course.exception.CustomArrayException;

public interface CountOfElemService {
    int calculateCountOfElem(CustomArray array) throws CustomArrayException;
}
