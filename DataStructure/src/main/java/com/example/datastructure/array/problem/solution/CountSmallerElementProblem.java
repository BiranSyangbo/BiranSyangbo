package com.example.datastructure.array.problem.solution;

public class CountSmallerElementProblem {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int[] ints = constructLowerArray(arr, arr.length);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    private static int[] constructLowerArray(int[] arr, int n) {
        int[] solu = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
            solu[i] = count;
        }
        return solu;
    }

}
