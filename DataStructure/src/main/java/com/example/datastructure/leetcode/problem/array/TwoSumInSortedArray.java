package com.example.datastructure.leetcode.problem.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumInSortedArray {

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(arr, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement))
                return new int[]{map.get(complement), i+1};
            map.put(numbers[i], i +1);
        }
        return new int[]{};
    }
}
