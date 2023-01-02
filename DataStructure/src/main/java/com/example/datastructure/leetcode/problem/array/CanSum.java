package com.example.datastructure.leetcode.problem.array;

public class CanSum {

    public static void main(String[] args) {
//        int[] arr = {3, 2, 1, 0, 4};
//        int[] arr = {2, 0, 0};
//        int[] arr = {2, 5, 0, 0};
        int[] arr = {2, 3, 1, 1, 4};
        System.out.println(canJump(arr));
        String s = "but";
        String ss = "sadbutsad";
        int i = ss.indexOf(s);
        System.out.println(i);
    }

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int last = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (i + nums[i] >= last) last = i;
        }
        return last <= 0;
    }
}
