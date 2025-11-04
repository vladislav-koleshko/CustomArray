package com.inkspac3.course.service.stream;

import com.inkspac3.course.entity.CustomArray;
import com.inkspac3.course.exception.CustomArrayException;

public interface ReplaceByConditionStreamService {
    void replaceByIndex(CustomArray array, int index, String newValue) throws CustomArrayException;
}
