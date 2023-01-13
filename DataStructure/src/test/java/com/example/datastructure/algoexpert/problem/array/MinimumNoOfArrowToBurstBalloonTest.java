package com.example.datastructure.algoexpert.problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumNoOfArrowToBurstBalloonTest {

    @Test
    void testCase0() {
        int[][] arr = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        assertEquals(2, MinimumNoOfArrowToBurstBallon.findMinArrowShots(arr));
    }

    @Test
    void testCase1() {
        int[][] arr = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        assertEquals(2, MinimumNoOfArrowToBurstBallon.findMinArrowShots(arr));
    }

    @Test
    void testCase2() {
        int[][] arr = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        assertEquals(4, MinimumNoOfArrowToBurstBallon.findMinArrowShots(arr));

    }

    @Test
    void testCase3() {
        int[][] arr = {{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};
        assertEquals(2, MinimumNoOfArrowToBurstBallon.findMinArrowShots(arr));
    }

}