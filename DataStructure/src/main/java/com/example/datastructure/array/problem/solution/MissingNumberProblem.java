package com.example.datastructure.array.problem.solution;

import java.util.Arrays;

public class MissingNumberProblem {
    public static void main(String[] args) {
        int[] arr = {2};
        int i = MissingNumber(arr, 2);
        System.out.println(i);
    }

    static int MissingNumber(int array[], int n) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        int sum1 = n * (n + 1) / 2;
        return sum1 - sum;
    }
}
