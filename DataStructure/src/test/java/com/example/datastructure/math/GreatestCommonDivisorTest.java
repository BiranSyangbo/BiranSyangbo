package com.example.datastructure.math;

import org.junit.jupiter.api.Test;

import static com.example.datastructure.math.GreatestCommonDivisor.gcd;
import static org.junit.jupiter.api.Assertions.*;

class GreatestCommonDivisorTest {


    @Test
    void testCase1() {
        assertEquals(32, gcd(96, 128));
    }


    @Test
    void testCase2() {
        assertEquals(2, gcd(22, 26));
    }

    @Test
    void testCase3() {
        assertEquals(30, gcd(210, 360));
    }

}