package com.example.datastructure.leetcode.problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DetectCapitalTest {

    @Test
    void testCase1() {
        assertTrue(DetectCapital.detectCapitalUse("uSA"));
        assertFalse(DetectCapital.detectCapitalUse("FlaG"));
        assertTrue(DetectCapital.detectCapitalUse("biran"));
    }
}