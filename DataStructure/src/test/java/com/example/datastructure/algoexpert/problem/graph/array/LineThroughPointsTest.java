package com.example.datastructure.algoexpert.problem.graph.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineThroughPointsTest {

    @Test
    public void TestCase1() {
        int[][] input = new int[][]{{1, 1}, {2, 2}, {3, 3}, {0, 4}, {-2, 6}, {4, 0}, {2, 1}};
        int expected = 4;
        int actual = LineThroughPoints.lineThroughPoints(input);
        assertEquals(expected, actual);
    }

}