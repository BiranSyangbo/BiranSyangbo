package com.example.datastructure.algoexpert.problem.array;

import java.util.*;

public class LongestRange {

    public int[] largestRange(int[] array) {
        Map<Integer, Boolean> visit = new HashMap<>();
        for (int i : array) {
            visit.put(i, false);
        }

        int[] ans = new int[2];
        int longestLength = 0;
        for (int i : array) {
            if (visit.get(i)) {
                continue;
            }
            int currentLength = 1; // i already visited i val
            int left = i - 1;
            int right = i + 1;
            visit.put(i, true);
            while (visit.containsKey(left)) {
                currentLength++;
                visit.put(left, true);
                left--;
            }

            while (visit.containsKey(right)) {
                currentLength++;
                visit.put(right, true);
                right++;
            }

            if (currentLength > longestLength) {
                longestLength = currentLength;
                ans = new int[]{left + 1, right - 1};
            }

        }
        return ans;
    }
}
