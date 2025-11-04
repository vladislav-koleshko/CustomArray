package com.inkspac3.course.service.stream.impl;

import com.inkspac3.course.entity.CustomArray;
import com.inkspac3.course.exception.CustomArrayException;
import com.inkspac3.course.service.stream.MinMaxStreamService;
import com.inkspac3.course.validator.CustomArrayValidator;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Comparator;

public class MinMaxStreamServiceImpl implements MinMaxStreamService {
    private static final Logger log = Logger.getLogger(MinMaxStreamServiceImpl.class);

    public String getMin(CustomArray array) throws CustomArrayException {
        if (array == null || array.size() == 0) {
            throw new CustomArrayException("Array is empty or null");
        }

        return Arrays.stream(array.get(), 0, array.size())
                .min(Comparator.comparingInt(String::length))
                .orElseThrow(() -> new CustomArrayException("No elements"));
    }

    public String getMax(CustomArray array) throws CustomArrayException {
        if (array == null || array.size() == 0) {
            throw new CustomArrayException("Array is empty or null");
        }

        return Arrays.stream(array.get(), 0, array.size())
                .max(Comparator.comparingInt(String::length))
                .orElseThrow(() -> new CustomArrayException("No elements"));
    }
}
