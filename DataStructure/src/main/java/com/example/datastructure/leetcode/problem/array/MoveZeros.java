package com.example.datastructure.leetcode.problem.array;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
        StringBuilder builder = new StringBuilder("Hello Biran Syangbo");
        System.out.println(builder.reverse().toString());
        String s = "a";
        byte[] bytes = s.getBytes();
        byte aByte = bytes[0];
        System.out.println(2%1);
    }

    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[j++] = nums[i];
        }
        Arrays.fill(nums, j, nums.length, 0);
    }
}
