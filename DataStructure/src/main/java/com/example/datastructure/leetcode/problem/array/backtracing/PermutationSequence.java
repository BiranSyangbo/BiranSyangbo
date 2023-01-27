package com.example.datastructure.leetcode.problem.array.backtracing;

import java.util.*;

public class PermutationSequence {
    public static void main(String[] args) {
        getPermutation(4, 9);
    }

    public static void getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        System.out.println(helper(nums, n, k, new ArrayList<>(), new StringBuilder(), new boolean[n]));
    }

    public static String helper(int[] nums, int n, int k, List<String> permutation, StringBuilder builder, boolean[] isUsed) {
        if (builder.length() == n) {
            String ans = builder.toString();
            permutation.add(ans);
            return ans;
        }
        for (int i = 0; i < n; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                builder.append(nums[i]);
                helper(nums, n, k, permutation, builder, isUsed);
                isUsed[i] = false;
                builder.deleteCharAt(builder.length() - 1);
            }
        }
        return permutation.size() > k - 1 ? permutation.get(k - 1) : "";
    }
}
