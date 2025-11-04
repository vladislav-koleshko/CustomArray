package com.inkspac3.course.service.impl;

import com.inkspac3.course.entity.CustomArray;
import com.inkspac3.course.exception.CustomArrayException;
import com.inkspac3.course.service.SortService;
import com.inkspac3.course.validator.CustomArrayValidator;

import java.util.Arrays;

public class SortServiceImpl implements SortService {

    private final CustomArrayValidator validator;

    public SortServiceImpl(CustomArrayValidator validator) {
        this.validator = validator;
    }

    @Override
    public CustomArray sortByLengthWMergeSort(CustomArray array) throws CustomArrayException {
        if(!validator.validateArray(array) && array.size() == 0) {
            throw new CustomArrayException("Array can't be null or empty");
        }

        String[] copy = Arrays.copyOf(array.get(), array.size());
        mergeSort(copy, 0, copy.length - 1);
        return new CustomArray(copy);
    }

    @Override
    public CustomArray sortByLengthWQuickSort(CustomArray array) throws CustomArrayException {
        if(!validator.validateArray(array) && array.size() == 0) {
            throw new CustomArrayException("Array can't be null or empty");
        }

        String[] copy = Arrays.copyOf(array.get(), array.size());
        quickSort(copy, 0, copy.length - 1);
        return new CustomArray(copy);
    }

    @Override
    public CustomArray sortByLengthWSelectionSort(CustomArray array) throws CustomArrayException {
        if(!validator.validateArray(array) && array.size() == 0) {
            throw new CustomArrayException("Array can't be null or empty");
        }

        String[] copy = Arrays.copyOf(array.get(), array.size());
        selectionSort(copy);
        return new CustomArray(copy);
    }


    private void mergeSort(String[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(String[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        String[] leftArr = new String[n1];
        String[] rightArr = new String[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i].length() <= rightArr[j].length()) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];
    }

    private void quickSort(String[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private int partition(String[] arr, int low, int high) {
        String pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].length() <= pivot.length()) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private void selectionSort(String[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].length() < arr[minIndex].length()) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
