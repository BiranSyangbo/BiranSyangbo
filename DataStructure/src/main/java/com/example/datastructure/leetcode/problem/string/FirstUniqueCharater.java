package com.example.datastructure.leetcode.problem.string;

public class FirstUniqueCharater {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("aabb"));
    }

    public static int firstUniqChar(String s) {
        int[] ch = new int[26];
        for (char c : s.toCharArray()) {
            ch[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (ch[c - 'a'] == 1)
                return i;
        }
        return -1;
    }
}
