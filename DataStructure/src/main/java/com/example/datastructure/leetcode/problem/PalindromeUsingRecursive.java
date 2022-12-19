package com.example.datastructure.leetcode.problem;

public class PalindromeUsingRecursive {
    public static void main(String[] args) {
//        System.out.println( isPalindrome("A"));
//        22 / 2; rem = 0
//        11 / 2; rem = 1
//        5 / 2; rem = 1
//        2 / 2; rem = 0
//        1 / 2; rem = 1
//        0

        System.out.println(8+1+32+64+128);
    }

    public static boolean isPalindrome(String ss) {
        if (ss.length() < 2) {
            return true;
        }

        if (ss.charAt(0) == ss.charAt(ss.length() - 1))
            return isPalindrome(ss.substring(1, ss.length() - 1));
        return false;
    }
}
