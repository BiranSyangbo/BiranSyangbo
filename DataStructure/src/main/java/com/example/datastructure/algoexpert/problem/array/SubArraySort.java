package com.example.datastructure.algoexpert.problem.array;

import java.util.Arrays;

public class SubArraySort {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 10, 11, 7, 12, 7, 7, 16, 18, 19};
        System.out.println(Arrays.toString(subarraySort(arr)));
    }

    public static int[] subarraySort(int[] array) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int[] result = {-1, -1};
        for (int i = 0; i < array.length; i++) {
            if (checkIsSorting(array[i], array, i)) {
                max = Math.max(max, array[i]);
                min = Math.min(min, array[i]);
            }
        }
        if (min == Integer.MAX_VALUE)
            return result;
        int i = 0;
        while (min >= array[i])
            i++;
        int j = array.length - 1;
        while (max <= array[j]) {
            j--;
        }
        return new int[]{i, j};

    }

    private static boolean checkIsSorting(int val, int[] array, int i) {
        if (i == 0)
            return val > array[i + 1];
        if (i == array.length - 1)
            return val < array[i - 1];
        return val < array[i - 1] || val > array[i + 1];
    }

}
