package com.inkspac3.service.impl;

import com.inkspac3.entity.CustomArray;
import com.inkspac3.exception.CustomArrayException;
import com.inkspac3.service.MinMaxService;
import com.inkspac3.validator.CustomArrayValidator;
import org.apache.log4j.Logger;

public class MinMaxServiceImpl implements MinMaxService {
    private final Logger log = Logger.getLogger(this.getClass().getName());
    private CustomArrayValidator validator;

    public MinMaxServiceImpl(CustomArrayValidator customArrayValidator) {
        this.validator = customArrayValidator;
    }

    @Override
    public String getMin(CustomArray array) throws CustomArrayException {
        validator.validateArray(array.size(), array);
        String min = "";
        for(var s : array) {
            if(min.isEmpty() || s.length() < min.length()) {
                min = s;
            }
        }
        log.info("min = " + min);
        return min;
    }

    @Override
    public String getMax(CustomArray array) throws CustomArrayException {
        validator.validateArray(array.size(), array);
        String max = "";
        for(var s : array) {
            if(max.isEmpty() || s.length() > max.length()) {
                max = s;
            }
        }
        log.info("max = " + max);
        return max;
    }
}
