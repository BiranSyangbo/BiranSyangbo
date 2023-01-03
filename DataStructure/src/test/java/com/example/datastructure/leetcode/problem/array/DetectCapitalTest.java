package com.example.datastructure.leetcode.problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DetectCapitalTest {

    @Test
    void testCase1() {
        assertTrue(DetectCapital.detectCapitalUse("USA"));
    }

    @Test
    void testCase2() {
        assertFalse(DetectCapital.detectCapitalUse("FlaG"));
    }

    @Test
    void testCase3() {
        assertTrue(DetectCapital.detectCapitalUse("biran"));
    }

    @Test
    void testCase4() {
        assertFalse(DetectCapital.detectCapitalUse("biraN"));
    }

    @Test
    void testCase5() {
        assertFalse(DetectCapital.detectCapitalUse("FaceBook"));
    }

    @Test
    void testCase6() {
        assertTrue(DetectCapital.detectCapitalUse("Facebook"));
    }

    @Test
    void testCase7() {
        assertFalse(DetectCapital.detectCapitalUse("mL"));
    }

    @Test
    void testCase8() {
        assertFalse(DetectCapital.detectCapitalUse("uSA"));
    }


}