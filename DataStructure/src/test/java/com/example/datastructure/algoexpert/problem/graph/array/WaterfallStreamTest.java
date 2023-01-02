package com.example.datastructure.algoexpert.problem.graph.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class WaterfallStreamTest {

    private WaterfallStream waterfallStream;

    @BeforeEach
    void setup() {
        waterfallStream = new WaterfallStream();
    }

    @Test
    public void TestCase1() {
        double[][] array =
                new double[][]{
                        {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                        {1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                        {0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0},
                        {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                        {1.0, 1.0, 1.0, 0.0, 0.0, 1.0, 0.0},
                        {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0},
                        {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
//                        {0, 0, 0, 0},
//                        {0, 1, 0, 0},
//                        {0, 0, 0, 0},
//                        {0, 0, 1, 0},
//                        {0, 0, 0, 0},
//                        {0, 1, 1, 0},
//                        {0, 0, 0, 0},
                };
        var source = 3;
        double[] expected = /*{62.5, 0, 0, 37.5};*/ {0.0, 0.0, 0.0, 25.0, 25.0, 0.0, 0.0};
        double[] actual = waterfallStream.waterfallStreams(array, source);
        System.out.println(Arrays.toString(actual));
        assertEquals(expected.length, actual.length);
        assertArrayEquals(expected, actual);
    }
}