package com.example.datastructure.leetcode.problem.sliding.window;

import org.junit.jupiter.api.Test;

import static com.example.datastructure.leetcode.problem.sliding.window.SubArrayDivisibleSum.subarraysDivByK;
import static org.junit.jupiter.api.Assertions.*;

class SubArrayDivisibleSumTest {

    @Test
    void testCase() {
        int[] arr = {4};
        int k = 5;
        assertEquals(0, subarraysDivByK(arr, k));
    }

    @Test
    void testCase1() {
        int[] arr = {4, 5, 0, -2, -3, 1};
        int k = 5;
        assertEquals(7, subarraysDivByK(arr, k));
    }

    @Test
    void testCase2() {
        int[] arr = {4, 5, 1, 10};
        int k = 5;
        assertEquals(4, subarraysDivByK(arr, k));
    }

    @Test
    void testCase3() {

    }
}