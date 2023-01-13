package com.example.datastructure.algoexpert.problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumIceCreamBarTest {

    @Test
    void testCase1() {
        int[] arr = {1, 3, 2, 4, 1, 10};
        int coin = 7;
        assertEquals(4, MaximumIceCreameBar.maxIceCream(arr, coin));
    }

}