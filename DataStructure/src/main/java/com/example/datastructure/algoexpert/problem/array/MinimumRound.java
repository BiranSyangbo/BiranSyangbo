package com.example.datastructure.algoexpert.problem.array;

import java.util.Arrays;

public class MinimumRound {


    public static int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        int count = 0;
        for (int i = 0; i < tasks.length; i++) {
            int j = i + 1;
            while (j < tasks.length && tasks[j - 1] == tasks[j])
                j++;
            int k = j - i;
            int val = minimumRoundsHelper(k);
            if (val == -1) {
                return -1;
            }
            count += val;
            i = j - 1;
        }
        return count;
    }

    public static int minimumRoundsHelper(int value) {
        int count = -1;
        if (value % 3 == 0) {
            count = value / 3;
        } else if (value > 1) {
            count = (value / 3) + 1;
        }
        return count;
    }
}
