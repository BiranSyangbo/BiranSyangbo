package com.example.datastructure.array.datastructure;

import com.example.datastructure.array.datastructure.sorting.SelectionSort;
import com.example.datastructure.random.GenerateRandom;

public class SortingArray {


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int size = 100000;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = GenerateRandom.random(0, 10000);
        }
//        BubbleSort.bubbleSort(arr);
//        QuickSort.quickSort(arr, 0, arr.length - 1);
//        RemoveFromArray.removeByIndex(arr, 5);
//        print(arr);
//        InsertionSort.sort(arr);

        SelectionSort.selectionSort(arr);
        System.out.println();
//        print(arr);
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println("Total Time " + (end - start));


    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
