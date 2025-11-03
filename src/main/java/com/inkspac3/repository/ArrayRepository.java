package com.inkspac3.repository;

import com.inkspac3.entity.CustomArray;
import com.inkspac3.exception.CustomArrayException;

import java.util.ArrayList;
import java.util.List;

public class ArrayRepository {
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
            throw new CustomArrayException("Array is null");
        }
        arrays.add(array);
    }

    public void deleteArray(CustomArray array) throws CustomArrayException {
        if (array == null) {
            throw new CustomArrayException("Array is null");
        }
        arrays.remove(array);
    }
}
