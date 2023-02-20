package com.example.datastructure.algoexpert.problem.array;

import java.util.*;

public class MaxSumArrayIncreasingSubSequence {

    public static void main(String[] args) {
        int[] list = {-1};
        System.out.println(maxSumIncreasingSubsequence(list));
    }

    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        var result = new int[array.length];
        var sequence = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < result.length; i++) {
            if (i == 0) {
                result[i] = array[i];
                sequence.put(i, List.of(array[i]));
            } else {
                int k = 0;
                int sum = array[i];
                var list = new ArrayList<Integer>();
                while (k < i) {
                    if (array[i] > array[k] && sum <= array[i] + result[k]) {
                        sum = array[i] + result[k];
                        list = new ArrayList<>(sequence.get(k));
                    }
                    k++;
                }
                result[i] = sum;
                list.add(array[i]);
                sequence.put(i, list);
            }
        }
        int max = Integer.MIN_VALUE;
        int position = 0;
        for (int i = 0; i < result.length; i++) {
            if (max < result[i]) {
                max = result[i];
                position = i;
            }
        }
        var lists = new ArrayList<List<Integer>>();
        lists.add(List.of(max));
        lists.add(sequence.get(position));
        return lists;
    }
}
