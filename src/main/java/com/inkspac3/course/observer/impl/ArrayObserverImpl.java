package com.inkspac3.course.observer.impl;

import com.inkspac3.course.entity.CustomArray;
import com.inkspac3.course.observer.ArrayObserver;
import org.apache.log4j.Logger;

import java.util.Arrays;

public class ArrayObserverImpl implements ArrayObserver {
    private static final Logger log = Logger.getLogger(ArrayObserverImpl.class);

    @Override
    public void update(Object obj) {
        if (obj instanceof CustomArray customArray) {
            log.info("CustomArray with id " + customArray.getId() + " has been updated. Current data: "
                    + Arrays.toString(customArray.get()));
        } else {
            log.warn("Update received for unknown object: " + obj);
        }
    }
}
