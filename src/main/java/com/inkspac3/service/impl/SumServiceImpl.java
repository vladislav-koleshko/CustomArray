package com.inkspac3.service.impl;

import com.inkspac3.entity.CustomArray;
import com.inkspac3.exception.CustomArrayException;
import com.inkspac3.service.SumService;
import com.inkspac3.validator.CustomArrayValidator;
import org.apache.log4j.Logger;

public class SumServiceImpl implements SumService {
    private final Logger log = Logger.getLogger(this.getClass().getName());
    private final CustomArrayValidator validator;

    public SumServiceImpl(CustomArrayValidator validator) {
        this.validator = validator;
    }

    @Override
    public int calculateSumLength(CustomArray array) throws CustomArrayException {
        if(!validator.validateArray(array)) {
            throw new CustomArrayException("Array can't be null or empty");
        }

        if (array.size() == 0) {
            return 0;
        }

        int sum = 0;
        for(var s : array) {
            sum += s.length();
        }
        log.info(String.format("Sum length: %d", sum));
        return sum;
    }
}
