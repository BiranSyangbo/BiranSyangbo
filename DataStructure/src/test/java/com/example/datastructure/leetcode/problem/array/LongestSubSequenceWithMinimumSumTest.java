package com.example.datastructure.leetcode.problem.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubSequenceWithMinimumSumTest {

    LongestSubSequenceWithMinimumSum service;

    @BeforeEach
    void setup() {
        service = new LongestSubSequenceWithMinimumSum();
    }

    @Test
    void testCase1() {
        final int[] nums = {4, 5, 2, 1};
        int[] queries = {3, 10, 21};
        final int[] ans = service.answerQueries(nums, queries);
        int[] expected = {2, 3, 4};
        System.out.println(Arrays.toString(ans));
        assertArrayEquals(expected, ans);
    }
}