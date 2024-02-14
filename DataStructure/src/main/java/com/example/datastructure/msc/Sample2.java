package com.example.datastructure.msc;

public class Sample2 {
    public static void main(String[] args) {
        int[] arr = {};
        f(arr);

    }

    private static int f(int[] arr) {
        int xSum = 0;
        int ySum = 0;
        for (int j : arr) {
            if (j % 2 == 0)
                xSum += j;
            else
                ySum += j;
        }
        return xSum - ySum;
    }
}
