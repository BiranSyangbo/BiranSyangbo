package com.example.datastructure.leetcode.problem;

public class ContainerWithMostWater11 {

    public static void main(String[] args) {

    }

    public static int maxArea(int[] height) {

        if (height.length == 2)
            return Math.min(height[0], height[1]);
        int back = height.length - 1;
        return 0;
    }
}
