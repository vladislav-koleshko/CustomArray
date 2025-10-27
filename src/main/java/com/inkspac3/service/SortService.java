package com.inkspac3.service;

import com.inkspac3.entity.CustomArray;
import com.inkspac3.exception.CustomArrayException;

public interface SortService {
    void sortByLengthWMergeSort(CustomArray array) throws CustomArrayException;
    void sortByLengthWQuickSort(CustomArray array) throws CustomArrayException;
    void sortByLengthWSelectionSort(CustomArray array) throws CustomArrayException;
}
