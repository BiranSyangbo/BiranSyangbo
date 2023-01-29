package com.example.datastructure.leetcode.problem.union.find;

import org.junit.jupiter.api.Test;

import static com.example.datastructure.leetcode.problem.union.find.NumberOfGoodPath.numberOfGoodPaths;
import static com.example.datastructure.leetcode.problem.union.find.NumberOfGoodPath.numberOfGoodPaths1;
import static org.junit.jupiter.api.Assertions.*;

class NumberOfGoodPathTest {

    @Test
    void testCase1() {
        int[] val = {1, 3, 2, 1, 3};
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}};
        assertEquals(6, numberOfGoodPaths(val, edges));
    }

    @Test
    void testCase2() {
        int[] val = {1, 1, 2, 2, 3};
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {2, 4}};
        assertEquals(7, numberOfGoodPaths(val, edges));
    }

    @Test
    void testCase3() {
        int[] val = {1};
        int[][] edges = {};
        assertEquals(1, numberOfGoodPaths(val, edges));
    }

    @Test
    void testCase4() {
        int[] val = {};
        int[][] edges = {{}};
        assertEquals(0, numberOfGoodPaths(val, edges));
    }

    @Test
    void testCase5() {
        int[] val = {2, 5, 5, 1, 5, 2, 3, 5, 1, 5};
        int[][] edges = {{0, 1}, {2, 1}, {3, 2}, {3, 4}, {3, 5}, {5, 6}, {1, 7}, {8, 4}, {9, 7}};
        assertEquals(20, numberOfGoodPaths(val, edges));
    }
}