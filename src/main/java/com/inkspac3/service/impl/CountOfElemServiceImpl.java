package com.inkspac3.service.impl;

import com.inkspac3.entity.CustomArray;
import com.inkspac3.service.CountOfElemService;
import org.apache.log4j.Logger;

public class CountOfElemServiceImpl implements CountOfElemService {
    private final Logger log = Logger.getLogger(this.getClass().getName());

    @Override
    public int calculateCountOfElem(CustomArray array) {
        log.info(String.format("Count of elements(%d)", array.size()));
        return array.size();
    }
}
