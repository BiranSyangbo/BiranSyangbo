package com.example.datastructure.leetcode.problem.tries;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordBreakTest {


    @Test
    void testCase1() {
        String s = "leetcode";
        List<String> strings = Arrays.asList("leet", "code");
        assertTrue(new WordBreak().wordBreak(s, strings));
    }

    @Test
    void testCase2() {
        String s = "applepenapple";
        List<String> strings = Arrays.asList("apple", "pen");
        assertTrue(new WordBreak().wordBreak(s, strings));
    }


    @Test
    void testCase3() {
        String s = "catsandog";
        List<String> strings = Arrays.asList("cats", "dog", "sand", "and", "cat");
        assertFalse(new WordBreak().wordBreak(s, strings));
    }

}