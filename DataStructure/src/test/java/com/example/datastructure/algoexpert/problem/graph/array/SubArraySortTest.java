package com.example.datastructure.algoexpert.problem.graph.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubArraySortTest {

    private SubArraySort subArraySort;

    @BeforeEach
    void setUp() {
        subArraySort = new SubArraySort();
    }

    @Test
    void testLessThan2() {
        int[] arr = {};
        assertArrayEquals(arr, subArraySort.subarraySort(arr));
    }

    @Test
    void testEqualAndSorted() {
        int[] arr = {2, 3};
        int[] ans = {-1, -1};
        assertArrayEquals(ans, subArraySort.subarraySort(arr));
    }

    @Test
    void testEqualSizeAndNotSorted() {
        int[] arr = {3, 2};
        int[] ans = {0, 1};
        assertArrayEquals(ans, subArraySort.subarraySort(arr));
    }
}