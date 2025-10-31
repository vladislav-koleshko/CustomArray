package com.inkspac3.service;

import com.inkspac3.entity.CustomArray;
import com.inkspac3.exception.CustomArrayException;

public interface SortService {
    CustomArray sortByLengthWMergeSort(CustomArray array) throws CustomArrayException;
    CustomArray sortByLengthWQuickSort(CustomArray array) throws CustomArrayException;
    CustomArray sortByLengthWSelectionSort(CustomArray array) throws CustomArrayException;
}
