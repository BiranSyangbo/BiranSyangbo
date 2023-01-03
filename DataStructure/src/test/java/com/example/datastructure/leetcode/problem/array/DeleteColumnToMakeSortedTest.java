package com.example.datastructure.leetcode.problem.array;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeleteColumnToMakeSortedTest {


    @Test
    void testCase1() {
        String[] str = {"zyx", "wvu", "tsr"};
        assertEquals(3, DeleteColumnToMakeSorted.minDeletionSize(str));
    }

    @Test
    void testCase2() {
        String[] str = {"a", "b", "c"};
        assertEquals(0, DeleteColumnToMakeSorted.minDeletionSize(str));
    }

    @Test
    void testCase3() {
        String[] str = {"rrjk", "furt", "guzm"};
        assertEquals(2, DeleteColumnToMakeSorted.minDeletionSize(str));
    }

    @Test
    void testCase4() {
        String[] str = {"qowfc", "spyge", "sqbif", "vvrkk"};
        assertEquals(1, DeleteColumnToMakeSorted.minDeletionSize(str));
    }
}