package com.example.datastructure.algoexpert.problem.assessments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Assessment1Test {

    @Test
    void test1() {
        var fileName = "abcdefg";
        var pattern = "a*e?g";
        assertTrue(Assessment1.dp(fileName, pattern));
    }

    @Test
    void test2() {
        var fileName = "abcdefg";
        var pattern = "*";
        assertTrue(Assessment1.dp(fileName, pattern));
    }

    @Test
    void test3() {
        var fileName = "abcdefg";
        var pattern = "*****a*?f*********g";
        assertTrue(Assessment1.dp(fileName, pattern));
    }

}