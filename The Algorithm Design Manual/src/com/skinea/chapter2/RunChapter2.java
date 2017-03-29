package com.skinea.chapter2;

import com.skinea.utils.ArrayOperations;

/**
 * Created by seckin on 30/03/2017.
 */
public class RunChapter2 {

    private static SelectionSort sorter;


    public static void main(String args[]) {

        sorter = new SelectionSort();
        int[] arr = {7, 3, 9, 5, 4, 4, 1, 11};

        System.out.println("## SELECTION SORT DEMO ##");

        System.out.println("Before selection sort:");
        ArrayOperations.printArray(arr);

        sorter.selectionSort(arr);

        System.out.println("After selection sort");
        ArrayOperations.printArray(arr);
    }
}
