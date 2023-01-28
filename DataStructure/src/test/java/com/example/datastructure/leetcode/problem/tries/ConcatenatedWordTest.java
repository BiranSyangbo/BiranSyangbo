package com.example.datastructure.leetcode.problem.tries;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConcatenatedWordTest {

    @Test
    void testCase() {
        String[] words = {"cat", "dog", "catdog"};
        List<String> results = Arrays.asList("catdog");
        List<String> wordList = new ConcatenatedWord().findAllConcatenatedWordsInADict(words);
        assertEquals(results.size(), wordList.size());
        for (String result : wordList) {
            assertTrue(results.contains(result));
        }
    }


    @Test
    void testCase1() {
        String[] words = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        List<String> results = Arrays.asList("catsdogcats", "dogcatsdog", "ratcatdogcat");
        List<String> wordList = new ConcatenatedWord().findAllConcatenatedWordsInADict(words);
        assertEquals(results.size(), wordList.size());
        for (String result : wordList) {
            assertTrue(results.contains(result));
        }
    }

    @Test
    void testCase2() {
        String[] words = {"a", "b", "ab", "abc"};
        List<String> results = Arrays.asList("ab");
        List<String> wordList = new ConcatenatedWord().findAllConcatenatedWordsInADict(words);
        assertEquals(results.size(), wordList.size());
        for (String result : wordList) {
            assertTrue(results.contains(result));
        }
    }

}