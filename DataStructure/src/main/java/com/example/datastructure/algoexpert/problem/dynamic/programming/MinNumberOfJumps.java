package com.example.datastructure.algoexpert.problem.dynamic.programming;

import java.util.Arrays;

public class MinNumberOfJumps {

    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3};
        minNumberOfJumps(arr);
    }

    public static int minNumberOfJumps(int[] array) {
        int[] jumps = new int[array.length];
        Arrays.fill(jumps, Integer.MAX_VALUE - 10);
        jumps[0] = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] + j >= i) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                }
            }
        }
        return jumps[array.length - 1];
    }
}
