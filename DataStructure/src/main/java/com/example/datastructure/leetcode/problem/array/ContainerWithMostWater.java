package com.example.datastructure.leetcode.problem.array;

// 11. Container With Most Water
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        if (height.length < 2)
            return 0;
        int j = height.length - 1;
        int i = 0;
        int max = 0;
        while (i < j) {
            int min = Math.min(height[i], height[j]);
            int m = (j - i) * min;
            max = Math.max(max, m);
            if (height[i] < height[j])
                i++;
            else
                j--;
        }
        return max;
    }
}
