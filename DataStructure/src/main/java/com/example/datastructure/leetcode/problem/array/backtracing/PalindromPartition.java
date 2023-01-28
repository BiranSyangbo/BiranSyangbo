package com.example.datastructure.leetcode.problem.array.backtracing;

import java.util.ArrayList;
import java.util.*;
import java.util.LinkedList;
import java.util.List;

public class PalindromPartition {
    public static void main(String[] args) {
        partition("aab");
//        Map<Integer, List<Integer>> unique = new HashMap();

    }


    static boolean validPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--))
                return false;
        }
        return true;
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        helper(s, ans, 0, new LinkedList<>());
        return ans;
    }

    static void helper(String s, List<List<String>> answer, int start, LinkedList<String> abc) {
        if (s.length() == start) {
            answer.add(new ArrayList<>(abc));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (validPalindrome(s, start, end)) {
                String ss = s.substring(start, end + 1);
                abc.addLast(ss);
                helper(s, answer, end + 1, abc);
                abc.removeLast();
            }
        }
    }
}
