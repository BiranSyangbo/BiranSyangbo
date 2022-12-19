package com.example.datastructure.leetcode.problem.string;

import java.util.HashMap;
import java.util.Map;

// 3. Longest Substring Without Repeating Characters
public class LongestSubString {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcaa"));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            char key = s.charAt(j);
            if (map.containsKey(key)) {
                i = Math.max(map.get(key), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(key, j + 1);
        }
        return ans;
    }
}
