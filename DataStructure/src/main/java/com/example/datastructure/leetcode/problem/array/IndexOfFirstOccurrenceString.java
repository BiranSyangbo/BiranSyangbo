package com.example.datastructure.leetcode.problem.array;

//28. Find the Index of the First Occurrence in a String
public class IndexOfFirstOccurrenceString {

    public int strStr(String haystack, String needle) {
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();
        if (n.length == 0 || h.length < n.length)
            return -1;
        int i = 0;
        int j = 0;
        while (i < h.length) {
            int k = i;
            while (j < n.length && k < h.length && h[k] == n[j]) {
                k++;
                j++;
            }
            if (j < n.length)
                j = 0;
            if (j >= n.length)
                return k - j;
            i++;
        }
        return -1;
    }
}
