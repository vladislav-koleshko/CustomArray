package com.inkspac3.service.impl;

import com.inkspac3.entity.CustomArray;
import com.inkspac3.service.AvgLengthService;
import org.apache.log4j.Logger;

public class AvgLengthServiceImpl implements AvgLengthService {
    private final Logger log = Logger.getLogger(this.getClass().getName());


    @Override
    public int calculateAvgLength(CustomArray array) {
        if(array.size() == 0) {
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
