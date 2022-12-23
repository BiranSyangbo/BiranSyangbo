package com.example.datastructure.algoexpert.problem.graph.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ZeroSumSubarray {

    public boolean zeroSumSubarray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int sum = 0;
        while (i < nums.length) {
            sum += nums[i];
            if (map.containsKey(0) || map.containsKey(sum)) {
                return true;
            }
            map.put(sum, sum);
            i++;
        }
        return map.containsKey(0);
    }
}
