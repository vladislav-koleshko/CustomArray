package com.inkspac3.course.service.impl;

import com.inkspac3.course.entity.CustomArray;
import com.inkspac3.course.exception.CustomArrayException;
import com.inkspac3.course.service.CountOfElemService;
import com.inkspac3.course.validator.CustomArrayValidator;
import org.apache.log4j.Logger;

public class CountOfElemServiceImpl implements CountOfElemService {
    private final Logger log = Logger.getLogger(this.getClass().getName());

    @Override
    public int calculateCountOfElem(CustomArray array) throws CustomArrayException {
        if(array == null) {
            throw new CustomArrayException("Array can't be null");
        }
        log.info(String.format("Count of elements(%d)", array.size()));
        return array.size();
    }
}
