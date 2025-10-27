package com.inkspac3.service.impl;

import com.inkspac3.entity.CustomArray;
import com.inkspac3.service.SumService;
import org.apache.log4j.Logger;

public class SumServiceImpl implements SumService {
    private final Logger log = Logger.getLogger(this.getClass().getName());


    @Override
    public int calculateSumLength(CustomArray array) {
        if (array.size() == 0) {
            return 0;
        }

        int sum = 0;
        for(var s : array) {
            sum += s.length();
        }
        log.info(String.format("Sum length: %d", sum));
        return sum;
    }
}
