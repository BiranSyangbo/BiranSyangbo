package com.example.datastructure.leetcode.problem;

public class PalindromeNumber9 {
    public static void main(String[] args) {
        System.out.println(isPalindromeByReverseHalf(1001));
        int a, b;
        a = b = 100;
        System.out.println(a + b);

    }

    public static boolean isPalindrome(int x) {
        int y = x;
        int b = 0;
        while (x > 0) {
            int pop = x % 10;
            x /= 10;
            b = b * 10 + pop;
        }
        return y == b;
    }

    public static boolean isPalindromeByReverseHalf(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reverseNumber = 0;
        while (x > reverseNumber) {
            reverseNumber = reverseNumber * 10 + x % 10;
            x /= 10;
        }

        return x == reverseNumber || x == reverseNumber / 10;
    }
}
