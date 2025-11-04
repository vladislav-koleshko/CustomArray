package com.inkspac3.course.service.impl;

import com.inkspac3.course.entity.CustomArray;
import com.inkspac3.course.exception.CustomArrayException;
import com.inkspac3.course.service.AvgLengthService;
import com.inkspac3.course.validator.CustomArrayValidator;
import org.apache.log4j.Logger;

public class AvgLengthServiceImpl implements AvgLengthService {
    private final Logger log = Logger.getLogger(this.getClass().getName());

    @Override
    public int calculateAvgLength(CustomArray array) throws CustomArrayException {
        if (array == null) {
            throw new CustomArrayException("Array can't be null");
        }

        if (array.size() == 0) {
            return 0;
        }

        int sum = 0;
        int avgLength;
        for (String str : array) {
            sum += str.length();
        }
        avgLength = sum / array.size();

        log.info(String.format("Avg length: %d", avgLength));
        return avgLength;
    }
}
