package com.inkspac3.service.impl;

import com.inkspac3.entity.CustomArray;
import com.inkspac3.exception.CustomArrayException;
import com.inkspac3.service.ReplaceByConditionService;
import com.inkspac3.validator.CustomArrayValidator;
import com.inkspac3.validator.CustomArrayValidatorImpl;
import org.apache.log4j.Logger;

public class ReplaceByConditionServiceImpl implements ReplaceByConditionService {
    private final Logger log = Logger.getLogger(this.getClass().getName());
    private CustomArrayValidator validator;

    public ReplaceByConditionServiceImpl(CustomArrayValidator validator) {
        this.validator = new CustomArrayValidatorImpl();
    }

    @Override
    public boolean replaceByIndex(int index, CustomArray array, String newValue) throws CustomArrayException {
        validator.validateArray(array.size(), array);
        array.get()[index] = newValue;
        log.info("Element " + index + " replaced with value " + newValue);
        return true;
    }
}
