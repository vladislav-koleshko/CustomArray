package com.inkspac3.course.service.stream.impl;

import com.inkspac3.course.entity.CustomArray;
import com.inkspac3.course.exception.CustomArrayException;
import com.inkspac3.course.service.stream.AvgLengthStreamService;
import org.apache.log4j.Logger;

import java.util.Arrays;

public class AvgLengthStreamServiceImpl implements AvgLengthStreamService {
    private static final Logger log = Logger.getLogger(AvgLengthStreamServiceImpl.class);

    public double calculateAvgLength(CustomArray array) throws CustomArrayException {
        if (array == null || array.size() == 0) {
            throw new CustomArrayException("Array is empty or null");
        }

        double avg = Arrays.stream(array.get(), 0, array.size())
                .mapToInt(String::length)
                .average()
                .orElse(0);

        log.info("Average string length = " + avg);
        return avg;
    }
}
