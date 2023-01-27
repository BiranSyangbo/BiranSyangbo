package com.example.datastructure.leetcode.problem.tries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPrefixTest {

    @Test
    void testCase() {
        String[] arr = {"flower", "flow", "flight"};
        assertEquals("fl", new LongestPrefix().longestCommonPrefix(arr));
    }

    @Test
    void testCase1() {
        String[] arr = {"flower"};
        assertEquals("flower", new LongestPrefix().longestCommonPrefix(arr));
    }

    @Test
    void testCase2() {
        String[] arr = {"dog", "racecar", "car"};
        assertEquals("", new LongestPrefix().longestCommonPrefix(arr));
    }

    @Test
    void testCase3() {
        String[] arr = {"ab", "a"};
        assertEquals("a", new LongestPrefix().longestCommonPrefix(arr));
    }

    @Test
    void testCase4() {
        String[] arr = {"aaa", "aa", "aaa"};
        assertEquals("aa", new LongestPrefix().longestCommonPrefix(arr));
    }

}