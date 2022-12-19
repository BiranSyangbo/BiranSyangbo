package com.example.datastructure.leetcode.problem.array;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums, 3, nums2, 3);
        System.out.println(Arrays.toString(nums));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int start = 0;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (nums1[i] != 0) {
                start = i + 1;
                break;
            }
        }
        int j = 0;
        for (int i = start; i < Math.max(m, n); i++) {
            if (nums1[i] == 0) {
                nums1[i] = nums2[j];
                j++;
            }
        }
        Arrays.sort(nums1);
    }
}
