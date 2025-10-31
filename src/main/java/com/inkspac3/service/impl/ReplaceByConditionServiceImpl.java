package com.inkspac3.service.impl;

import com.inkspac3.entity.CustomArray;
import com.inkspac3.exception.CustomArrayException;
import com.inkspac3.service.ReplaceByConditionService;
import com.inkspac3.validator.CustomArrayValidator;
import com.inkspac3.validator.impl.CustomArrayValidatorImpl;
import org.apache.log4j.Logger;

public class ReplaceByConditionServiceImpl implements ReplaceByConditionService {
    private final Logger log = Logger.getLogger(this.getClass().getName());
    private CustomArrayValidator validator;


    public ReplaceByConditionServiceImpl(CustomArrayValidator validator) {
        this.validator = new CustomArrayValidatorImpl();
    }

    @Override
    public String replaceByIndex(int index, CustomArray array, String newValue) throws CustomArrayException {
        if(!validator.validateArray(array)) {
            throw new CustomArrayException("Array can't be null");
        }

        array.get()[index] = newValue;
        log.info("Element " + index + " replaced with value " + newValue);
        return array.get()[index];
    }
}
