package com.inkspac3.course.service.stream.impl;

import com.inkspac3.course.entity.CustomArray;
import com.inkspac3.course.exception.CustomArrayException;
import com.inkspac3.course.service.stream.SumStreamService;
import org.apache.log4j.Logger;

import java.util.Arrays;

public class SumStreamServiceImpl implements SumStreamService {
    private static final Logger log = Logger.getLogger(SumStreamServiceImpl.class);

    public int sumOfLengths(CustomArray array) throws CustomArrayException {
        if (array == null || array.size() == 0) {
            throw new CustomArrayException("Array is empty or null");
        }

        int sum = Arrays.stream(array.get(), 0, array.size())
                .mapToInt(String::length)
                .sum();

        log.info("Total length sum = " + sum);
        return sum;
    }
}
