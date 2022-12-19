package com.example.datastructure.leetcode.problem;

import java.util.Arrays;

public class ThreeSumClosestOfTarget {

    public static void main(String[] args) {
        int[] arr = {-1,2,1,-4};

        System.out.println(threeSumClosest(arr, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int abs = Math.abs(sum - target);
                if (abs < diff) {
                    ans = sum;
                    diff = abs;
                }
                if (sum < target)
                    j++;
                else
                    k--;
            }
        }
        return ans;
    }
}
