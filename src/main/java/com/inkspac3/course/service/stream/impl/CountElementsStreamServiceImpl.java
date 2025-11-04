package com.inkspac3.course.service.stream.impl;

import com.inkspac3.course.entity.CustomArray;
import com.inkspac3.course.exception.CustomArrayException;
import com.inkspac3.course.service.stream.CountElementsStreamService;
import com.inkspac3.course.validator.CustomArrayValidator;
import org.apache.log4j.Logger;

import java.util.Arrays;

public class CountElementsStreamServiceImpl implements CountElementsStreamService {
    private static final Logger log = Logger.getLogger(CountElementsStreamServiceImpl.class);

    public long countElements(CustomArray array) throws CustomArrayException {
        if (array == null || array.size() == 0) {
            throw new CustomArrayException("Array is empty or null");
        }

        long count = Arrays.stream(array.get(), 0, array.size()).count();

        log.info("Element count = " + count);
        return count;
    }
}
