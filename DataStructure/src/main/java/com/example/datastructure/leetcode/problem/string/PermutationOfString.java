package com.example.datastructure.leetcode.problem.string;

public class PermutationOfString {
    public static void main(String[] args) {
        String val = "ABC";
        permutation(val, 0, val.length() - 1);

    }

    static void permutation(String s, int start, int end) {
        if (end == start)
            System.out.println(s);
        else
            for (int i = start; i <= end; i++) {
                s = swap(s, start, i);
                permutation(s, start + 1, end);
            }
    }

    static String swap(String s, int start, int end) {
        char[] ch = s.toCharArray();
        char temp = ch[start];
        ch[start] = ch[end];
        ch[end] = temp;
        return new String(ch);
    }
}
