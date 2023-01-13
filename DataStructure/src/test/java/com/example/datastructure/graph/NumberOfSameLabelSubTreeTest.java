package com.example.datastructure.graph;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.example.datastructure.graph.NumberOfSameLabelSubTree.countSubTrees;
import static com.example.datastructure.graph.NumberOfSameLabelSubTree.countSubTrees1;
import static org.junit.jupiter.api.Assertions.*;

class NumberOfSameLabelSubTreeTest {

    @Test
    void testCase1() {
        int[][] edges = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        int[] ans = {2, 1, 1, 1, 1, 1, 1};
        String label = "abaedcd";
        assertArrayEquals(ans, countSubTrees1(7, edges, label));
    }

    @Test
    void testCase2() {
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {0, 4}};
        int[] ans = {2, 1, 1, 1, 1};
        String label = "adbab";
        assertArrayEquals(ans, countSubTrees1(5, edges, label));
    }

    @Test
    void testCase3() {
        int[][] edges = {{0, 2}, {0, 3}, {1, 2}};
        int[] ans = {1, 1, 2, 1};
        String label = "aeed";
        assertArrayEquals(ans, countSubTrees1(4, edges, label));
    }
}