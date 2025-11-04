package com.inkspac3.course.service;

import com.inkspac3.course.entity.CustomArray;
import com.inkspac3.course.exception.CustomArrayException;

public interface SortService {
    CustomArray sortByLengthWMergeSort(CustomArray array) throws CustomArrayException;
    CustomArray sortByLengthWQuickSort(CustomArray array) throws CustomArrayException;
    CustomArray sortByLengthWSelectionSort(CustomArray array) throws CustomArrayException;
}
