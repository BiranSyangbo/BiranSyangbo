package com.example.datastructure.leetcode.problem.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class SubArrayDivisibleSum {

    // 4,5,1,10
    public static int subarraysDivByK(int[] nums, int k) {
        int prefix = 0, result = 0;
        Map<Integer, Integer> counter = new HashMap<>();
        counter.put(0, 1);
        for (int num : nums) {
            prefix = (prefix + num % k + k) % k;
            result += counter.getOrDefault(prefix, 0);
            counter.compute(prefix, (key, value) -> counter.getOrDefault(key, 0) + 1);
        }

        return result;
    }
}
