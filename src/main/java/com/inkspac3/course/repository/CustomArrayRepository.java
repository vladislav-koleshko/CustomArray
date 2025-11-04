package com.inkspac3.course.repository;

import com.inkspac3.course.entity.CustomArray;
import com.inkspac3.course.exception.CustomArrayException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayRepository {
    private static final Logger log = Logger.getLogger(CustomArrayRepository.class);

    private static CustomArrayRepository instance;
    private final List<CustomArray> arrays = new ArrayList<>();


    private CustomArrayRepository() {}

    public static CustomArrayRepository getInstance() {
        if (instance == null) {
            instance = new CustomArrayRepository();
        }
        return instance;
    }

    public void addArray(CustomArray array) throws CustomArrayException {
        if (array == null) {
            log.error(array + " is null");
            throw new CustomArrayException("Array is null");
        }
        log.info(array + " is added");
        arrays.add(array);
    }

    public void deleteArray(CustomArray array) throws CustomArrayException {
        if (array == null) {
            log.error(array + " is null");
            throw new CustomArrayException("Array is null");
        }
        log.info(array + " is deleted");
        arrays.remove(array);
    }
}
