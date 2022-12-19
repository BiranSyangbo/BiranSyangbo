package com.example.datastructure.array.datastructure.sorting;

// Complexity
// Time :- O(nlogn)
public class MergeSort {

    public static void mergeSort(int[] array, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(array, l, m);
            mergeSort(array, m + 1, r);
            merge(array, l, m, r);
        }
    }

    private static void merge(int[] array, int l, int m, int r) {
//        System.out.println("l + = " + l + " m " + m + " r " + r);
        int first = m - l + 1;
        int second = r - m;
        int[] firstArray = new int[first];
        int[] secondArray = new int[second];

        for (int i = 0; i < first; i++) {
            firstArray[i] = array[i + l];
        }

        for (int i = 0; i < second; i++) {
            secondArray[i] = array[m + 1 + i];
        }

        int i = 0, j = 0, k = l;

        while (i < first && j < second) {
            if (firstArray[i] < secondArray[j]) {
                array[k] = firstArray[i];
                i++;
            } else {
                array[k] = secondArray[j];
                j++;
            }
            k++;
        }
        while (i < first) {
            array[k] = firstArray[i];
            i++;
            k++;
        }
        while (j < second) {
            array[k] = secondArray[j];
            j++;
            k++;
        }


    }
}
