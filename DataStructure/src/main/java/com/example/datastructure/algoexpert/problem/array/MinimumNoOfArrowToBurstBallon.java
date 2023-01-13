package com.example.datastructure.algoexpert.problem.array;

import java.util.Arrays;
import java.util.Comparator;

// 452 Minimum Number of Arrows to burst Balloons
public class MinimumNoOfArrowToBurstBallon {

    // {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
    //  {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
    //  {{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};
    public static int findMinArrowShots(int[][] points) {
        int count = 1;
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int j = 0;
        for (int i = 1; i < points.length; i++) {
            if (points[j][1] >= points[i][0])
                continue;
            else {
                j = i;
            }
            count++;
        }
        return count;
    }
}
