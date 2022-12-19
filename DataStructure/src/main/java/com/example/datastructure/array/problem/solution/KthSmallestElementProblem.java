package com.example.datastructure.array.problem.solution;

import java.util.Arrays;

public class KthSmallestElementProblem {
    public static void main(String[] args) {
        int[] arr = Utils.convert("7 10 4 20 15", " ");
        int i = kthSmallest(arr, 0, arr.length - 1, 4);
        System.out.println(i);
    }

    public static int kthSmallest(int[] arr, int l, int r, int k) {
        Arrays.sort(arr);
        return arr[k - 1];
    }

}
