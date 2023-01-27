package com.example.datastructure.leetcode.problem.tries;


import org.springframework.web.servlet.tags.EscapeBodyTag;

import javax.xml.stream.events.StartDocument;
import java.util.Arrays;

public class LongestPrefix {

    // Horizontal Scanning
    // Because we search lcp in every index example( first we search at first after complete we will search in second and so on)
    public String longestCommonPrefix1(String[] strs) {
        StringBuilder prefix = new StringBuilder(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            int min = Math.min(prefix.length(), strs[i].length());
            int j = 0;
            for (; j < min; j++) {
                if (prefix.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            prefix.setLength(j);
        }
        return prefix.toString();
    }

    // Vertical Scanning
    // Because search will perform in all the list at a time
    // e.g. First loop will run till the length of 0 index data
    // and in every loop we will match i th character in every list
    public String longestCommonPrefix2(String[] list) {
        if (list == null || list.length == 0)
            return "";
        String prefix = list[0];
        for (int i = 0; i < prefix.length(); i++) {
            char ch = list[0].charAt(i);
            for (String s : list) {
                if (i == s.length() || ch != s.charAt(i))
                    return list[0].substring(0, i);
            }
        }
        return prefix;
    }

    // Divide And Conquer
    public String longestCommonPrefix3(String[] list) {
        if (list == null || list.length == 0)
            return "";
        if (list.length == 1)
            return list[0];
        return divideAndConquer(list, 0, list.length - 1);
    }

    String divideAndConquer(String[] list, int start, int end) {
        if (start == end)
            return list[end];
        else {
            int mid = (end + start) / 2;
            String s = divideAndConquer(list, start, mid);
            String l = divideAndConquer(list, mid + 1, end);
            return commonPrefix(s, l);
        }
    }

    String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i))
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }

    boolean commonPrfix(String[] str, int index) {
        String prefix = str[0].substring(0, index);
        for (String s : str) {
            if (s.indexOf(prefix) != 0)
                return false;
        }
        return true;
    }

    // Binary Search
    public String longestCommonPrefix(String[] list) {
        int minLength = Integer.MAX_VALUE;
        for (String s : list) {
            minLength = Math.min(s.length(), minLength);
        }
        int start = 0;
        while (start < minLength) {
            int mid = (minLength + start) / 2;
            if (commonPrfix(list, mid)) {
                start = mid + 1;
            } else
                minLength = mid - 1;
        }
        return list[0].substring(0, (start + minLength) / 2);
    }

}
