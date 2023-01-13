package com.example.datastructure.math;


public class GreatestCommonDivisor {
    public static int gcd(int val1, int val2) {
        while (true) {
            if (val1 == 0)
                return val2;
            if (val2 == 0)
                return val1;
            int val = val2;
            val2 = val1 % val2;
            val1 = val;
        }
    }
}
