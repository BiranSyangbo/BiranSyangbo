package com.example.datastructure.algoexpert.problem.assessments;

import java.util.Arrays;

public class Assessment1 {

    public static boolean globMatching(String fileName, String pattern) {
        return matching(fileName, pattern, 0, 0);
    }

    static boolean matching(String fileName, String pattern, int i, int j) {
        if (i == fileName.length() && pattern.length() == j)
            return true;
        else if (i <= fileName.length() && j < pattern.length()) {
            boolean firstChar = (fileName.length() > i && (fileName.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?'));
            if (firstChar)
                return matching(fileName, pattern, i + 1, j + 1);
            else if (pattern.charAt(j) == '*')
                return matching(fileName, pattern, i + 1, j + 1) || matching(fileName, pattern, i + 1, j) || matching(fileName, pattern, i, j + 1);
            else
                return false;
        } else
            return false;

    }

    static boolean dp(String text, String pattern) {
        int f = text.length();
        int p = pattern.length();
        boolean[][] dp = new boolean[f + 1][p + 1];
        dp[0][0] = true;

        for (int i = 1; i <= p; i++) {
            if (pattern.charAt(i - 1) == '*')
                dp[0][i] = dp[0][i - 1];
        }
        for (boolean[] booleans : dp) {
            System.out.println(Arrays.toString(booleans));
        }
        for (int i = 1; i <= f; i++) {
            for (int j = 1; j <= p; j++) {
                if (text.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        for (boolean[] booleans : dp) {
            System.out.println(Arrays.toString(booleans));
        }
        return dp[f][p];
    }
}
