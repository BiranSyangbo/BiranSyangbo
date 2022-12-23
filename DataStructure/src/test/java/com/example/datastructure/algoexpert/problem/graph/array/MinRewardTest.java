package com.example.datastructure.algoexpert.problem.graph.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinRewardTest {


    @Test
    public void TestCase1() {
        assertEquals(25, MinReward.minRewards(new int[]{8, 4, 2, 1, 3, 6, 7, 9, 5}));
    }

    @Test
    public void TestCase2() {
        assertEquals(8, MinReward.minRewards(new int[]{8, 4, 1, 6}));
    }

    @Test
    public void TestCase3() {
        assertEquals(21, MinReward.minRewards(new int[]{8, 4, 3, 2, 1, 0}));
    }

    @Test
    public void TestCase4() {
        assertEquals(3, MinReward.minRewards(new int[]{4, 8}));
    }

    @Test
    void testCase5() {
        assertEquals(0, MinReward.minRewards(new int[0]));
    }

    @Test
    void testCase6() {
        assertEquals(1, MinReward.minRewards(new int[]{1}));
    }
}