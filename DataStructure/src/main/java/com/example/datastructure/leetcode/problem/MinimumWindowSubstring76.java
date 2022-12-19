package com.example.datastructure.leetcode.problem;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring76 {

    public static void main(String[] args) {
        int[] arr = {23, 2, 4, 6, 6};
        System.out.println(checkSubarraySum(arr, 7));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>(Map.of(0,0));
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!map.containsKey(sum % k)) {
                map.put(sum % k, i + 1);
            } else if (map.get(sum % k) < i)
                return true;
        }
        return false;
    }


}
