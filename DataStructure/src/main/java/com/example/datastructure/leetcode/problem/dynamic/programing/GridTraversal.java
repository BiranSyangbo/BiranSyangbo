package com.example.datastructure.leetcode.problem.dynamic.programing;

import java.util.HashMap;

public class GridTraversal {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        HashMap<String, Long> integerIntegerHashMap = new HashMap<>();
        System.out.println(traverse(10, 10, integerIntegerHashMap));
    }


    public static long traverse(int i, int j, HashMap<String, Long> map) {
        String key = i + ":" + j;
        if (map.containsKey(key))
            return map.get(key);
        if (i <= 0 || j <= 0)
            return 0;
        else if (i == 1 && j == 1)
            return 1;
        long i1 = traverse(i - 1, j, map) + traverse(i, j - 1, map);
        map.put(key, i1);
        return map.get(key);

    }
}
