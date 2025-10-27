package com.inkspac3.service.impl;

import com.inkspac3.entity.CustomArray;
import com.inkspac3.exception.CustomArrayException;
import com.inkspac3.service.SortService;

public class SortServiceImpl implements SortService {

    @Override
    public void sortByLengthWMergeSort(CustomArray array) throws CustomArrayException {
        if (array == null || array.size() <= 1) {
            throw new CustomArrayException("Array is empty");
        }
        mergeSort(array, 0, array.size() - 1);
    }

    @Override
    public void sortByLengthWQuickSort(CustomArray array) throws CustomArrayException {
        if (array == null || array.size() <= 1) {
            throw new CustomArrayException("Array is empty");
        }
        quickSort(array, 0, array.size() - 1);
    }

    @Override
    public void sortByLengthWSelectionSort(CustomArray array) throws CustomArrayException {
        if (array == null || array.size() <= 1) {
            throw new CustomArrayException("Array is empty");
        }
        selectionSort(array);
    }


    private void quickSort(CustomArray array, int low, int high) throws CustomArrayException {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private void mergeSort(CustomArray array, int left, int right) throws CustomArrayException {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private void selectionSort(CustomArray array) throws CustomArrayException {
        int n = array.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (array.getElem(j).length() < array.getElem(minIndex).length()) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                swap(array, i, minIndex);
            }
        }
    }

    private int partition(CustomArray array, int low, int high) throws CustomArrayException {
        String pivot = array.getElem(low);
        int left = low + 1;
        int right = high;

        while (true) {
            while (left <= right && array.getElem(left).length() <= pivot.length()) {
                left++;
            }
            while (right >= left && array.getElem(right).length() >= pivot.length()) {
                right--;
            }
            if (right < left) break;
            swap(array, left, right);
        }

        swap(array, low, right);
        return right;
    }

    private void merge(CustomArray array, int left, int mid, int right) throws CustomArrayException {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        String[] leftArr = new String[n1];
        String[] rightArr = new String[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = array.getElem(left + i);
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = array.getElem(mid + 1 + j);
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i].length() <= rightArr[j].length()) {
                array.set(k++, leftArr[i++]);
            } else {
                array.set(k++, rightArr[j++]);
            }
        }

        while (i < n1) {
            array.set(k++, leftArr[i++]);
        }

        while (j < n2) {
            array.set(k++, rightArr[j++]);
        }
    }

    private void swap(CustomArray array, int i, int j) throws CustomArrayException {
        String temp = array.getElem(i);
        array.set(i, array.getElem(j));
        array.set(j, temp);
    }
}