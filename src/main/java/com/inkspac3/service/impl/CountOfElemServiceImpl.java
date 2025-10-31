package com.inkspac3.service.impl;

import com.inkspac3.entity.CustomArray;
import com.inkspac3.exception.CustomArrayException;
import com.inkspac3.service.CountOfElemService;
import com.inkspac3.validator.CustomArrayValidator;
import org.apache.log4j.Logger;

public class CountOfElemServiceImpl implements CountOfElemService {
    private final Logger log = Logger.getLogger(this.getClass().getName());
    private final CustomArrayValidator validator;

    public CountOfElemServiceImpl(CustomArrayValidator validator) {
        this.validator = validator;
    }

    @Override
    public int calculateCountOfElem(CustomArray array) throws CustomArrayException {
        if(!validator.validateArray(array)) {
            throw new CustomArrayException("Array can't be null");
        }
        log.info(String.format("Count of elements(%d)", array.size()));
        return array.size();
    }
}
