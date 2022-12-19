package com.example.datastructure.leetcode.problem.array;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 2;
        rotateLeetCode(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotateLeetCode(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k -1);
        reverse(nums, k, nums.length - 1);
    }

    static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }

    public static void rotate(int[] nums, int k) {
        if (nums.length == 0)
            return;
        int shift = k % nums.length;
        int j = nums.length - shift;
        int[] arr = new int[nums.length];
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < k && j < nums.length) {
                arr[i] = nums[j];
                j++;
            } else {
                arr[i] = nums[a];
                a++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }
    }
}
