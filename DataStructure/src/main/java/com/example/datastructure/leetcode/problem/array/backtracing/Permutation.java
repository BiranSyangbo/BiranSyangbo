package com.example.datastructure.leetcode.problem.array.backtracing;

import org.apache.el.lang.EvaluationContext;

import java.util.*;

public class Permutation {

    public static void main(String[] args) {
//        int[] arr = {1, 2, 3};
//        permute(arr);

//        int[] a = {1, 1, 2, 2};
//        List<List<Integer>> lists = permuteUnique(a);
//        System.out.println(lists);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            stringBuilder.append(i);
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        System.out.println(stringBuilder);
        System.out.println(find("ae", "aae"));

    }


    public static char find(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.compute(c, (k, v) -> count.getOrDefault(k, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (count.containsKey(c)) {
                count.put(c, count.get(c) - 1);
                if (count.get(c) < 0)
                    return c;
            } else
                return c;
        }
        return '0';

    }

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> permutatino = new ArrayList<>();
        List<List<Integer>> solution = new ArrayList<>();
        helper1(nums, permutatino, solution, new boolean[nums.length]);
        return solution;
    }

    static void helper1(int[] nums, List<Integer> permutation, List<List<Integer>> solution, boolean[] isUsed) {
        if (permutation.size() == nums.length) {
            solution.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                permutation.add(nums[i]);
                helper1(nums, permutation, solution, isUsed);
                isUsed[i] = false;
                permutation.remove((Integer) nums[i]);
            }
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<Integer> permutation = new LinkedList<>();
        List<List<Integer>> solution = new ArrayList<>();
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.compute(num, (k, v) -> counter.getOrDefault(k, 0) + 1);
        }
        helper(nums.length, permutation, solution, counter);
        return solution;
    }

    static void helper(int n, LinkedList<Integer> permutation, List<List<Integer>> solution, Map<Integer, Integer> counter) {
        System.out.println(permutation);
        if (permutation.size() == n) {
            solution.add(new ArrayList<>(permutation));
            return;
        }
        for (Map.Entry<Integer, Integer> count : counter.entrySet()) {
            int key = count.getKey();
            int val = count.getValue();
            if (val == 0)
                continue;
            permutation.addLast(key);
            counter.put(key, val - 1);
            helper(n, permutation, solution, counter);
            permutation.removeLast();
            counter.put(key, val);
        }
    }


}
