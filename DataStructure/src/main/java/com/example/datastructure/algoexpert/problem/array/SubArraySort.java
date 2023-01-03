package com.example.datastructure.algoexpert.problem.array;

public class SubArraySort {

    public int[] subarraySort(int[] array) {
        if (array.length < 2)
            return new int[]{};
        int[] arr = new int[]{-1, -1};
        for (int i = 0; i < array.length - 1; i++) {
            int j = array.length - 1;
            if (array[i] < array[i + 1]) {
                while (i < j) {
                    if (array[i] >= array[j]) {
                        return new int[]{i, j};
                    }
                    j--;
                }
            }else {
                j = j+1;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
            }

        }
        return arr;
    }
}
