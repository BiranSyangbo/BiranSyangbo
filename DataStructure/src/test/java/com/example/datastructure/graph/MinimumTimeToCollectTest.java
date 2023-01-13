package com.example.datastructure.graph;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.example.datastructure.graph.MinimumTimeToCollect.minTime;
import static com.example.datastructure.graph.MinimumTimeToCollect.minTime1;
import static org.junit.jupiter.api.Assertions.*;

class MinimumTimeToCollectTest {

    @Test
    void testCase1() {
        int[][] edges = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        List<Boolean> hasApple = Arrays.asList(false, false, true, false, true, true, false);
        assertEquals(8, minTime(7, edges, hasApple));
        assertEquals(8, minTime1(7, edges, hasApple));
    }

    @Test
    void tesCase2() {
        int[][] edges = {{0, 2}, {0, 3}, {1, 2}};
        List<Boolean> hasApple = Arrays.asList(false, true, false, false);
        assertEquals(4, minTime(4, edges, hasApple));
        assertEquals(4, minTime1(4, edges, hasApple));
    }

}