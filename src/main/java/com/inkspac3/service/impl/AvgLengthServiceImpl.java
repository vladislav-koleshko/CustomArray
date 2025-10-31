package com.inkspac3.service.impl;

import com.inkspac3.entity.CustomArray;
import com.inkspac3.exception.CustomArrayException;
import com.inkspac3.service.AvgLengthService;
import com.inkspac3.validator.CustomArrayValidator;
import org.apache.log4j.Logger;

public class AvgLengthServiceImpl implements AvgLengthService {
    private final Logger log = Logger.getLogger(this.getClass().getName());
    private final CustomArrayValidator validator;

    public AvgLengthServiceImpl(CustomArrayValidator validator) {
        this.validator = validator;
    }

    @Override
    public int calculateAvgLength(CustomArray array) throws CustomArrayException {
        if (!validator.validateArray(array)) {
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
