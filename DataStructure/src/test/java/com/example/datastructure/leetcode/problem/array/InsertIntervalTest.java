package com.example.datastructure.leetcode.problem.array;

import org.junit.jupiter.api.Test;

import static com.example.datastructure.leetcode.problem.array.InsertInterval.insert;
import static org.junit.jupiter.api.Assertions.*;

class InsertIntervalTest {


    @Test
    void testCase() {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] ans = {{1, 5}, {6, 9}};
        assertArrayEquals(ans, insert(intervals, newInterval));
    }

    @Test
    void tetCase1() {
        int[][] intervals = {};
        int[] newInterval = {};
        int[][] ans = {{}};
        assertArrayEquals(ans, insert(intervals, newInterval));
    }

    @Test
    void testCase2() {
//        int[][] intervals = {{1, 2}, {3, 5}, {4, 8}, {6, 7}, {8, 10}, {12, 16}};
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] ans = {{1, 2}, {3, 10}, {12, 16}};
        assertArrayEquals(ans, insert(intervals, newInterval));
    }

    @Test
    void testCase3() {
        int[][] intervals = {};
        int[] newInterval = {5, 7};
        int[][] ans = {{5, 7}};
        assertArrayEquals(ans, insert(intervals, newInterval));
    }


    @Test
    void testCase4() {
        int[][] intervals = {{1, 3}};
        int[] newInterval = {2, 5};
        int[][] ans = {{1, 5}};
        assertArrayEquals(ans, insert(intervals, newInterval));
    }

    @Test
    void testCase5() {
        int[][] intervals = {{1, 3}};
        int[] newInterval = {4, 5};
        int[][] ans = {{1, 3}, {4, 5}};
        int[][] result = insert(intervals, newInterval);
        assertArrayEquals(ans, result);
    }

    @Test
    void testCase6() {
        int[][] intervals = {{1, 5}};
        int[] newInterval = {0, 3};
        int[][] ans = {{0, 5}};
        int[][] result = insert(intervals, newInterval);
        assertArrayEquals(ans, result);
    }

    @Test
    void testCase7() {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {0, 5};
        int[][] ans = {{0, 5}, {6, 9}};
        assertArrayEquals(ans, insert(intervals, newInterval));
    }

    @Test
    void testCase8() {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {0, 0};
        int[][] ans = {{0, 0}, {1, 3}, {6, 9}};
        assertArrayEquals(ans, insert(intervals, newInterval));
    }
}