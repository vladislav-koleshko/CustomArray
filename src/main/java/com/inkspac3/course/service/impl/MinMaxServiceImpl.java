package com.inkspac3.course.service.impl;

import com.inkspac3.course.entity.CustomArray;
import com.inkspac3.course.exception.CustomArrayException;
import com.inkspac3.course.service.MinMaxService;
import com.inkspac3.course.validator.CustomArrayValidator;
import org.apache.log4j.Logger;

public class MinMaxServiceImpl implements MinMaxService {
    private final Logger log = Logger.getLogger(this.getClass().getName());
    private final CustomArrayValidator validator;

    public MinMaxServiceImpl(CustomArrayValidator validator) {
        this.validator = validator;
    }

    @Override
    public int getMin(CustomArray array) throws CustomArrayException {
        if(array == null) {
            throw new CustomArrayException("Array can't be null");
        }
        String min = "";
        for(var s : array) {
            if(min.isEmpty() || s.length() < min.length()) {
                min = s;
            }
        }
        log.info("min = " + min);
        return min.length();
    }

    @Override
    public int getMax(CustomArray array) throws CustomArrayException {
        if(array == null) {
            throw new CustomArrayException("Array can't be null");
        }

        String max = "";
        for(var s : array) {
            if(max.isEmpty() || s.length() > max.length()) {
                max = s;
            }
        }
        log.info("max = " + max);
        return max.length();
    }
}
