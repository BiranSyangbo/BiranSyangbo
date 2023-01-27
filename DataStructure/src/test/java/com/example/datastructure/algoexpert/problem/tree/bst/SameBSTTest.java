package com.example.datastructure.algoexpert.problem.tree.bst;

import org.junit.jupiter.api.Test;

import java.util.*;

import static com.example.datastructure.algoexpert.problem.tree.bst.SameBST.sameBsts;
import static org.junit.jupiter.api.Assertions.*;

class SameBSTTest {
    @Test
    public void TestCase1() {
        List<Integer> arrayOne = new ArrayList<>(Arrays.asList(10, 15, 8, 12, 94, 81, 5, 2, 11));
        List<Integer> arrayTwo = new ArrayList<>(Arrays.asList(10, 8, 5, 15, 2, 12, 11, 94, 81));
        assertTrue(sameBsts(arrayOne, arrayTwo));
    }
}