package com.skinea.utils;

/**
 * Created by seckin on 29/03/2017.
 */
public class ArrayOperations {

    public static void swap(int[] arr, int idx1, int idx2) {

        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;

    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) System.out.print(" - ");
        }
        System.out.println("\n");
    }
}

