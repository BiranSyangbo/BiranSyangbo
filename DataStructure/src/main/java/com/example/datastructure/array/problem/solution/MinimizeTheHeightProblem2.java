package com.example.datastructure.array.problem.solution;

import java.util.Arrays;

public class MinimizeTheHeightProblem2 {
    public static void main(String[] args) {

    }

    int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int max = arr[n - 1];
        int min = arr[0];
        int diff = max - min;
        for (int i = 1; i < n; i++) {
            max = Math.max(arr[n - 1] - k, arr[i - 1] + k);
            min = Math.min(arr[0] + k, arr[i] - k);
            if (arr[i] - k < 0)
                continue;
            diff = Math.min(diff, max - min);
        }
        return diff;
    }

}
