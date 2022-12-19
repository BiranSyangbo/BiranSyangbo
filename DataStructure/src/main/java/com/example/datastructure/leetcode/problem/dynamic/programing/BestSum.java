package com.example.datastructure.leetcode.problem.dynamic.programing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Write a function that takes in a targetsum and array of number as a arguments;
// The function should return an array containing the shortest combination of numbers that add up to exactly the target Sum;
// if there is a tie for the shortest combination, you may return any one of the shortest;
public class BestSum {


    public static void main(String[] args) {
        System.out.println(bestSum(100, new int[]{1, 2, 5, 25}, new HashMap<>()));
    }

    public static List<Integer> bestSum(int targetNum, int[] numbers, Map<Integer, List<Integer>> map) {
        if (map.containsKey(targetNum))
            return map.get(targetNum);
        if (targetNum == 0)
            return new ArrayList<>();
        if (targetNum < 0)
            return null;
        List<Integer> result = null;
        for (int number : numbers) {
            int reminder = targetNum - number;
            var val = bestSum(reminder, numbers, map);
            if (val != null) {
                List<Integer> copy = new ArrayList<>(val);
                copy.add(number);
                if (result == null || copy.size() < result.size()) {
                    result = copy;
                }
            }
        }
        map.put(targetNum, result);
        return result;
    }
}
