package com.example.datastructure.leetcode.problem;

public class BinarySearchUsingRecursion {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearch(arr, 0, arr.length - 1, 1));
    }

    public static int binarySearch(int[] arr, int start, int end, int searchVal) {
        if (start > end)
            return -1;
        int mid = (start + end) / 2;
        if (searchVal == arr[mid])
            return mid;
        if (arr[mid] > searchVal) {
            return binarySearch(arr, start, mid - 1, searchVal);
        }
        return binarySearch(arr, mid + 1, end, searchVal);
    }
}
