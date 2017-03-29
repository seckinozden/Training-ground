package com.skinea.chapter1;

import com.skinea.utils.ArrayOperations;

/**
 * Created by seckin on 29/03/2017.
 */
public class InsertionSort {

    public void insertionSort(int[] arr) {

        int i, j = 0;

        for (i = 1; i < arr.length; i++) {
            j=i;
            while ((j > 0) && (arr[j] < arr[j - 1])) {
                ArrayOperations.swap(arr, j, j - 1);
                j = j - 1;
            }
        }
    }
}
