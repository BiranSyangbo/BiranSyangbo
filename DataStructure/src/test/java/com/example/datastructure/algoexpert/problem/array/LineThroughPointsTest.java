package com.example.datastructure.algoexpert.problem.array;

import org.junit.jupiter.api.Test;

import static com.example.datastructure.algoexpert.problem.array.LineThroughPoints.lineThroughPoints;
import static org.junit.jupiter.api.Assertions.*;

class LineThroughPointsTest {

    @Test
    public void TestCase1() {
        int[][] input = new int[][]{{1, 1}, {2, 2}, {3, 3}, {0, 4}, {-2, 6}, {4, 0}, {2, 1}};
        int expected = 4;
        int actual = lineThroughPoints(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCase2() {
        int[][] input = {{2, 3}, {3, 3}, {-5, 3}};
        assertEquals(3, lineThroughPoints(input));
    }


    @Test
    public void testCase3() {
        int[][] input = {{0, 0}, {1, -1}, {1, 1}};
        assertEquals(2, lineThroughPoints(input));
    }
}