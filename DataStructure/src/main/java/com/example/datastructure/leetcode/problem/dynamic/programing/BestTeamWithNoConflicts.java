package com.example.datastructure.leetcode.problem.dynamic.programing;

import java.util.Arrays;
import java.util.Comparator;

public class BestTeamWithNoConflicts {
    public static void main(String[] args) {
        int[] scores = {1, 3, 7, 3, 2, 4, 10, 7, 5};
        int[] ages = {4, 5, 2, 1, 1, 2, 4, 1, 4};
        System.out.println(bestTeamScore(scores, ages));
    }

    public static int bestTeamScore(int[] scores, int[] ages) {
        int[][] scoreList = new int[scores.length][2];
        for (int i = 0; i < scores.length; i++) {
            int score = scores[i];
            scoreList[i] = new int[]{ages[i], score};
        }
        Arrays.sort(scoreList, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int bestScores = 0;
        int dp[] = new int[scores.length];
        for (int i = 0; i < scoreList.length; i++) {
            dp[i] = scoreList[i][1];
            bestScores = Math.max(bestScores, dp[i]);
        }
        for (int i = 0; i < scoreList.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (scoreList[i][1] >= scoreList[j][1]) {
                    dp[i] = Math.max(dp[i], scoreList[i][1] + dp[j]);
                }
            }
            bestScores = Math.max(bestScores, dp[i]);
        }
        return bestScores;
    }

    private static int findMaxScore(int[][] ageScorePair) {
        int n = ageScorePair.length;
        int answer = 0;

        int[] dp = new int[n];
        // Initially, the maximum score for each player will be equal to the individual scores.
        for (int i = 0; i < n; i++) {
            dp[i] = ageScorePair[i][1];
            answer = Math.max(answer, dp[i]);
        }


        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                // If the players j and i could be in the same team.
                if (ageScorePair[i][1] >= ageScorePair[j][1]) {
                    // Update the maximum score for the ith player.
                    dp[i] = Math.max(dp[i], ageScorePair[i][1] + dp[j]);
                }
            }
            // Maximum score among all the players.
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }

    public static int bestTeamScore1(int[] scores, int[] ages) {
        int N = ages.length;
        int[][] ageScorePair = new int[N][2];

        for (int i = 0; i < N; i++) {
            ageScorePair[i][0] = ages[i];
            ageScorePair[i][1] = scores[i];
        }

        // Sort in ascending order of age and then by score.
        Arrays.sort(ageScorePair, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        return findMaxScore(ageScorePair);
    }
}
