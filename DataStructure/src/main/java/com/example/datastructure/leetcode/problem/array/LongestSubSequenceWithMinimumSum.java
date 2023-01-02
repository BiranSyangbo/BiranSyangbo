package com.example.datastructure.leetcode.problem.array;

import java.util.*;

// 2389. Longest Subsequence With Limited Sum
public class LongestSubSequenceWithMinimumSum {

    public int[] answerQueries(int[] nums, int[] queries) {
        int[] answer = new int[queries.length];
        Arrays.sort(nums);
        Map<Integer, Integer> sumMap = new HashMap<>();
        int count = 0;
        int sum = 0;
        for (int num : nums) {
            count++;
            sum += num;
            sumMap.put(sum, count);
        }
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i];
            while (val >= 0 && !sumMap.containsKey(val))
                val--;
            answer[i] = sumMap.getOrDefault(val, 0);
        }
        return answer;
    }

}
