package com.test;

import java.util.HashMap;
import java.util.Map;

public class Tst {
    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 1, 2, 3, 4, 2, 5, 6, 4};
//        int[] arr = {1, 0, 2, 0, 1};
        int shortPath = Integer.MAX_VALUE;
        Map<Integer, Integer> path = new HashMap<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            int val = arr[i];
            if (path.containsKey(val)) {
                int p = path.get(val) - i;
                shortPath = Math.min(p, shortPath);
            } else {
                path.put(val, i);
            }
        }
        System.out.println(shortPath);
    }
}
