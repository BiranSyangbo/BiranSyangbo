package com.example.datastructure.leetcode.problem.dynamic.programing.string;

public class FlipStringToMonotoneIncreasing {

    public static int minFlipsMonoIncr(String s) {
        int countFlip = 0, count1 = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                countFlip = Math.min(count1, countFlip + 1);
            } else {
                ++count1;
            }
        }
        return countFlip;
    }

}
