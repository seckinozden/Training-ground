package com.skinea.chapter1;

import com.skinea.utils.ArrayOperations;

/**
 * Created by seckin on 30/03/2017.
 */
public class RunChapter1 {

    private static InsertionSort sorter;


    public static void main(String args[]){

        int[] arr={7,3,9,5,4,4,1,11};

        sorter = new InsertionSort();

        System.out.println("## INSERTION SORT DEMO ##");

        System.out.println("Before insertion sort:");
        ArrayOperations.printArray(arr);

        sorter.insertionSort(arr);

        System.out.println("After insertion sort:");
        ArrayOperations.printArray(arr);
    }
}
