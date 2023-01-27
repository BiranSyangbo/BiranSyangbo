package com.example.datastructure.leetcode.problem.array;

import java.util.*;

public class FindJudge {

    public static void main(String[] args) {
        int[][] arr = {};
        System.out.println(findJudge(1, arr));
    }

    public static int findJudge(int n, int[][] trust) {
        int[] unique = new int[n + 1];
        int[] result = new int[n + 1];

        for (int[] t : trust) {
            unique[t[0]]++;
            result[t[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (unique[i] == 0) {
                if (result[i] == n - 1)
                    return i;
                break;
            }
        }
        return -1;
    }

    static int dfs(int i, Map<Integer, List<Integer>> graph, boolean[] visited) {
        return 0;
    }

    ;
}
