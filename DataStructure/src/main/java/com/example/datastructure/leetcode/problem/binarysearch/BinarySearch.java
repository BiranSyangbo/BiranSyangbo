package com.example.datastructure.leetcode.problem.binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-1};
        System.out.println(10 >> 5);
        System.out.println(search(arr, -1));
    }

    public static int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = nums[mid];

            if (midVal < target)
                low = mid + 1;
            else if (midVal > target)
                high = mid - 1;
            else
                return mid;
        }
        return -1;
    }
}
