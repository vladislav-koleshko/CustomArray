package com.inkspac3.course.service.stream.impl;

import com.inkspac3.course.entity.CustomArray;
import com.inkspac3.course.exception.CustomArrayException;
import com.inkspac3.course.service.stream.ReplaceByConditionStreamService;
import com.inkspac3.course.validator.CustomArrayValidator;
import org.apache.log4j.Logger;

import java.util.stream.IntStream;

public class ReplaceByConditionStreamServiceImpl implements ReplaceByConditionStreamService {
    private static final Logger log = Logger.getLogger(ReplaceByConditionStreamServiceImpl.class);

    public void replaceByIndex(CustomArray array, int index, String newValue) throws CustomArrayException {
    if (array == null || array.size() == 0) {
        throw new CustomArrayException("Array is empty or null");
    }
        if (index < 0 || index >= array.size()) {
        throw new CustomArrayException("Index out of bounds");
    }

    String[] modified = IntStream.range(0, array.size())
            .mapToObj(i -> i == index ? newValue : array.get()[i])
            .toArray(String[]::new);

        System.arraycopy(modified, 0, array.get(), 0, array.size());
        log.info("Replaced element at index " + index);
}
}
