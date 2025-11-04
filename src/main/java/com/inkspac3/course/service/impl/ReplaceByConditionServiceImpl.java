package com.inkspac3.course.service.impl;

import com.inkspac3.course.entity.CustomArray;
import com.inkspac3.course.exception.CustomArrayException;
import com.inkspac3.course.service.ReplaceByConditionService;
import com.inkspac3.course.validator.CustomArrayValidator;
import com.inkspac3.course.validator.impl.CustomArrayValidatorImpl;
import org.apache.log4j.Logger;

public class ReplaceByConditionServiceImpl implements ReplaceByConditionService {
    private final Logger log = Logger.getLogger(this.getClass().getName());

    @Override
    public String replaceByIndex(int index, CustomArray array, String newValue) throws CustomArrayException {
        if(array == null) {
            throw new CustomArrayException("Array can't be null");
        }

        array.get()[index] = newValue;
        log.info("Element " + index + " replaced with value " + newValue);
        return array.get()[index];
    }
}
