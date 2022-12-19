package com.example.datastructure.leetcode.problem.dynamic.programing;

import java.util.HashMap;
import java.util.Map;

// Write a function that takes in a targetSum and array of number as a argument
// the function should return a boolean indicating wether or not it is possible to  generate the targetsum
// using number from the array.
// you may use a element of array as many times as needed
// you may assumes that all numbers are non-negative
public class CanSum {

    public static void main(String[] args) {
        System.out.println(canSum(7, new int[]{2, 3}, new HashMap<>()));
        System.out.println(canSum(7, new int[]{5, 3, 4, 7}, new HashMap<>()));
        System.out.println(canSum(8, new int[]{2, 5, 3}, new HashMap<>()));
        System.out.println(canSum(100, new int[]{7, 14}, new HashMap<>()));
    }

    public static boolean canSum(int targetSum, int[] arr) {
        if (targetSum == 0)
            return true;
        if (targetSum < 0)
            return false;
        for (int num : arr) {
            int reminder = targetSum - num;
            if (canSum(reminder, arr))
                return true;
        }
        return false;
    }

    // using dynamic programing
    public static boolean canSum(int targetSum, int[] arr, Map<Integer, Boolean> memo) {
        if (memo.containsKey(targetSum))
            return memo.get(targetSum);
        if (targetSum == 0)
            return true;
        if (targetSum < 0)
            return false;
        for (int num : arr) {
            int reminder = targetSum - num;
            if (canSum(reminder, arr)) {
                memo.put(targetSum, true);
                return memo.get(targetSum);
            }

        }
        memo.put(targetSum, false);
        return memo.get(targetSum);
    }
}
