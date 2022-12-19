package com.example.datastructure.array.datastructure.sorting;

public class SelectionSort {

    // Result size = 100000 :- 7375
    public static void sort(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            int min = arr[i];
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                }
            }
            arr[i] = min;
        }
    }
    public static void selectionSort(int array[]) {
        int size = array.length;

        for (int step = 0; step < size - 1; step++) {
            int min_idx = step;

            for (int i = step + 1; i < size; i++) {

                // To sort in descending order, change > to < in this line.
                // Select the minimum element in each loop.
                if (array[i] < array[min_idx]) {
                    min_idx = i;
                }
            }

            // put min at the correct position
            int temp = array[step];
            array[step] = array[min_idx];
            array[min_idx] = temp;
        }
    }
}
