package com.inkspac3.service;

import com.inkspac3.entity.CustomArray;
import com.inkspac3.exception.CustomArrayException;

public interface ReplaceByConditionService {
    String replaceByIndex(int index, CustomArray array, String newValue) throws CustomArrayException;
}
