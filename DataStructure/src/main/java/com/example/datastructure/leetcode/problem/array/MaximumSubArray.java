package com.example.datastructure.leetcode.problem.array;

public class MaximumSubArray {

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int previous = 0;
        for (int i = 0; i < nums.length; i++) {
            previous += nums[i];
            if (previous > ans)
                ans = previous;
            if (previous < 0)
                previous = 0;
        }
        return ans;
    }
}
