package com.inkspac3.repository;

import com.inkspac3.entity.CustomArray;
import com.inkspac3.exception.CustomArrayException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ArrayRepository {
    private static final Logger log = Logger.getLogger(ArrayRepository.class);

    private static ArrayRepository instance;
    private final List<CustomArray> arrays = new ArrayList<>();


    private ArrayRepository() {}

    public static ArrayRepository getInstance() {
        if (instance == null) {
            instance = new ArrayRepository();
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
