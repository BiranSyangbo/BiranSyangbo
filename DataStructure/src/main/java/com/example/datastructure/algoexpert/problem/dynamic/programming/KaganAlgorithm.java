package com.example.datastructure.algoexpert.problem.dynamic.programming;

public class KaganAlgorithm {
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 4, 5};
        int i = second(arr);
        System.out.println(i);
    }

    public static int kadanesAlgorithm(int[] array) {
        int[] result = new int[array.length];
        result[0] = array[0];
        int ans = array[0];
        for (int i = 1; i < array.length; i++) {
            if (result[i - 1] < 0) {
                result[i] = array[i];
            } else {
                result[i] = result[i - 1] + array[i];
            }
            ans = Math.max(result[i], ans);
        }
        return ans;
    }

    static int second(int[] arr) {
        int max = arr[0];
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max + arr[i], arr[i]);
            result = Math.max(result, max);
        }
        return result;
    }
}
