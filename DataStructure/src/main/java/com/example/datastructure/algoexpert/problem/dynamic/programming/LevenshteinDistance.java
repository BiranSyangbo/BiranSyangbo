package com.example.datastructure.algoexpert.problem.dynamic.programming;

public class LevenshteinDistance {
    public static int levenshteinDistance(String str1, String str2) {
        int s1 = str1.length();
        int s2 = str2.length();
        int[][] dp = new int[s1 + 1][s2 + 1];
        for (int i = 0; i < s1 + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < s2 + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {
                int first = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                int third = dp[i - 1][j - 1];
                if (str1.charAt(i - 1) != str2.charAt(j - 1)) {
                    third++;
                }
                dp[i][j] = Math.min(first, third);
            }
        }
        return dp[s1][s2];
    }
}
