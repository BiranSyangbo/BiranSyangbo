package com.example.datastructure.leetcode.problem.dynamic.programing.string;

import org.junit.jupiter.api.Test;

import static com.example.datastructure.leetcode.problem.dynamic.programing.string.FlipStringToMonotoneIncreasing.minFlipsMonoIncr;
import static org.junit.jupiter.api.Assertions.*;

class FlipStringToMonotoneIncreasingTest {


    @Test
    void testCase() {
        assertEquals(1, minFlipsMonoIncr("00110"));
    }

    @Test
    void testCase1() {
        assertEquals(2, minFlipsMonoIncr("010110"));
    }

    @Test
    void testCase2() {
        assertEquals(2, minFlipsMonoIncr("00011000"));
    }

    @Test
    void testCase3() {
        assertEquals(0, minFlipsMonoIncr("00000"));
    }

    @Test
    void testCase4() {
        assertEquals(0, minFlipsMonoIncr("11"));
    }

    @Test
    void testCase5() {
        assertEquals(1, minFlipsMonoIncr("00110"));
    }

    @Test
    void testCase6() {
        assertEquals(1, minFlipsMonoIncr("00110"));
    }

    @Test
    void testCase7() {
        assertEquals(3, minFlipsMonoIncr("0101100011"));
    }
}