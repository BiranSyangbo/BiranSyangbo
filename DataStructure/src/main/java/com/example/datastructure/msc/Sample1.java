package com.example.datastructure.msc;

public class Sample1 {
    public static void main(String[] args) {
        int[] arr = {10,4,2,4,3};
        System.out.println(a1(arr));
    }

    static int sample1(int[] arr) {
        if (arr == null || arr.length % 2 == 0) {
            return 0;
        }

        int mid = arr.length / 2;
        for (int i = 0; i < mid; i++) {
            int ms = arr[mid - i];
            int me = arr[mid + i];
            int start = arr[mid - i - 1];
            int end = arr[mid + i + 1];
            if (start <= ms || end <= me) {
                return 0;
            }
        }
        return 1;

    }

    static int a1(int[] a) {
        if (a == null || a.length % 2 == 0) return 0;
        int midIndex = a.length / 2;
        int middleItem = a[midIndex];
        for (int i = 0; i < a.length; i++) {
            if (i != midIndex && middleItem >= a[i])
                return 0;
        }
        return 1;
    }

    static int check(int[] arr, int back) {
        if (back < 0)
            return 0;
        int val = arr[back];
        if (val > arr[back + 1]) {
            return 0;
        }

        return 1;
    }
}
