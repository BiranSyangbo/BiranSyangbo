package com.example.datastructure.array.datastructure.sorting;

public class InsertionSort {

//     Try function
//    public static void insertionSort(int[] arr) {
//        int size = arr.length;
//        for (int i = 0; i < size; i++) { // i = 1
//            int k = 0;
//            while (true) {
//                if (arr[k] > arr[i]) {
//                    int temp = arr[k];
//                    arr[k] = arr[i];
//                    arr[i] = temp;
//                }
//                if (i == k)
//                    break;
//                k++;
//            }
//        }
//    }

    public static void sort(int[] arr) {

        int size = arr.length;
        for (int i = 1; i < size; i++) { // 1 2
            int j = i - 1; /// j = 0
            int key = arr[i];  // 2

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key; //
        }
    }

}
