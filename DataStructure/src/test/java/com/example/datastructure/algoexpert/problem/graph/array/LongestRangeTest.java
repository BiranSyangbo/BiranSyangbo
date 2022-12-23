package com.example.datastructure.algoexpert.problem.graph.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LongestRangeTest {

    private LongestRange longestRange;

    @BeforeEach
    void setup() {
        this.longestRange = new LongestRange();
    }

    @Test
    void test() {
        int[] arr = {};
        int[] ints = longestRange.largestRange(arr);
//        System.out.println(Arrays.toString(ints));
//        assertEquals("", );
    }
}