package com.example.datastructure.array.problem.solution;

public class KadanesProblem {

    public static void main(String[] args) {

        int arr[] = {-1, -2, -3, -4};
        long l = maxSubarraySum(arr, arr.length);
        System.out.println(l);

    }

    static long maxSubarraySum(int arr[], int n) {
        int max = 0;
        int gMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) { // 1
            max = Math.max(arr[i], arr[i] + max); // -2 ,  -2+-1
            if (gMax <= max) {
                gMax = max;
            }
        }
        return gMax;
    }

}
