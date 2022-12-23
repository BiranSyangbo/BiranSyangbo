package com.example.datastructure.algoexpert.problem.graph.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZeroSumSubarrayTest {

    private ZeroSumSubarray zeroSumSubarray;

    @BeforeEach
    void setup() {
        this.zeroSumSubarray = new ZeroSumSubarray();
    }

    @Test
    void testZeroWithEmptyArray() {
        int[] arr = {};
        assertFalse(zeroSumSubarray.zeroSumSubarray(arr));
    }

    @Test
    void testZeroSumSubArray() {
        int[] arr = {0};
        assertTrue(zeroSumSubarray.zeroSumSubarray(arr));
    }

    @Test
    void testWithSameNumber() {
        int[] arr = {0, 0, 0, 0};
        assertTrue(zeroSumSubarray.zeroSumSubarray(arr));
        arr = new int[]{1, 1, 1, 1};
        assertFalse(zeroSumSubarray.zeroSumSubarray(arr));
        arr = new int[]{-1, -1, -1, -1};
        assertFalse(zeroSumSubarray.zeroSumSubarray(arr));
    }

    @Test
    void testZeroSum() {
        int[] arr = {1, 2, -2, 3};
        assertTrue(zeroSumSubarray.zeroSumSubarray(arr));
    }

    @Test
    void testWithNonZero() {
        int[] arr = {-5, 2, 2, 3, -6};
        assertFalse(zeroSumSubarray.zeroSumSubarray(arr));
    }

}