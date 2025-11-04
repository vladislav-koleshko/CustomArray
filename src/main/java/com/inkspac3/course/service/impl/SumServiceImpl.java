package com.inkspac3.course.service.impl;

import com.inkspac3.course.entity.CustomArray;
import com.inkspac3.course.exception.CustomArrayException;
import com.inkspac3.course.service.SumService;
import com.inkspac3.course.validator.CustomArrayValidator;
import org.apache.log4j.Logger;

public class SumServiceImpl implements SumService {
    private final Logger log = Logger.getLogger(this.getClass().getName());

    @Override
    public int calculateSumLength(CustomArray array) throws CustomArrayException {
        if(array == null) {
            throw new CustomArrayException("Array can't be null");
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
