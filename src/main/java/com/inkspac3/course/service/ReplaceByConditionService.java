package com.inkspac3.course.service;

import com.inkspac3.course.entity.CustomArray;
import com.inkspac3.course.exception.CustomArrayException;

public interface ReplaceByConditionService {
    String replaceByIndex(int index, CustomArray array, String newValue) throws CustomArrayException;
}
