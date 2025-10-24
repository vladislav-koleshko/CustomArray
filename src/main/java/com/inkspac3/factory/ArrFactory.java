package com.inkspac3.factory;

import com.inkspac3.entities.CustomArray;
import com.inkspac3.exception.InvalidArgumentException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ArrFactory {
    private static final Logger log = LogManager.getLogger(ArrFactory.class);

    private ArrFactory() {}

    public static CustomArray createArray(int size) {
        if (size <= 0) {
            log.error("Размер массива должен быть больше нуля");
            throw new InvalidArgumentException("Размер массива должен быть больше нуля");
        }
        return new CustomArray(size);
    }
}
