package com.inkspac3.course.service.stream.impl;

import com.inkspac3.course.entity.CustomArray;
import com.inkspac3.course.service.stream.SortServiceStream;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Comparator;

public class SortServiceStreamImpl implements SortServiceStream {
    private static final Logger log = Logger.getLogger(SortServiceStreamImpl.class);

    @Override
    public void sortAscending(CustomArray array) {
        String[] sorted = Arrays.stream(array.get(), 0, array.size())
                .sorted(Comparator.comparingInt(String::length))
                .toArray(String[]::new);
        System.arraycopy(sorted, 0, array.get(), 0, sorted.length);
    }

    @Override
    public void sortDescending(CustomArray array) {
        String[] sorted = Arrays.stream(array.get(), 0, array.size())
                .sorted(Comparator.comparingInt(String::length).reversed())
                .toArray(String[]::new);
        System.arraycopy(sorted, 0, array.get(), 0, sorted.length);
    }
}
