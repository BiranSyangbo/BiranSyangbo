package com.example.datastructure.algoexpert.problem.array;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ZigZagTraverseTest {


    @Test
    public void TestCase1() {
        List<List<Integer>> test = new ArrayList<>();
        test.add(new ArrayList<>(Arrays.asList(1, 3, 4, 10)));
        test.add(new ArrayList<>(Arrays.asList(2, 5, 9, 11)));
        test.add(new ArrayList<>(Arrays.asList(6, 8, 12, 15)));
        test.add(new ArrayList<>(Arrays.asList(7, 13, 14, 16)));
        List<Integer> expected =
                new ArrayList<>(
                        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16));
        assertArrayEquals(expected.toArray(), ZigZagTraverse.zigzagTraverse(test).toArray());
    }

}