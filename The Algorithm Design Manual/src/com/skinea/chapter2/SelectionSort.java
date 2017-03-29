package com.skinea.chapter2;

import com.skinea.utils.ArrayOperations;

/**
 * Created by seckin on 30/03/2017.
 */
public class SelectionSort {

    private static int min_idx;

    public static void selectionSort(int[] arr){

        int i,j=0;
        min_idx = 0;

        for(i=0; i<arr.length; i++){
            min_idx =i;
            for(j=i+1; j<arr.length; j++ )
                if(arr[j]<arr[min_idx]) min_idx=j;

            ArrayOperations.swap(arr,i,min_idx);

        }
    }
}
