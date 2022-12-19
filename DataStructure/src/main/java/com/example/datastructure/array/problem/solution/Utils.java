package com.example.datastructure.array.problem.solution;

import java.util.Arrays;

public class Utils {
    public static int[] convert(String ar, String denote) {
        return Arrays.stream(ar.split(denote)).mapToInt(Integer::parseInt).toArray();
    }
}
