package com.example.datastructure.algoexpert.problem.bst;

import java.util.*;


public class RightSmallerThan {
    // 5, 4, 4, 0, 1, 1, 0
    public static void main(String[] args) {
        System.out.println(rightSmallerThan(Arrays.asList(8, 5, 11, -1, 3, 4, 2)));
    }

    public static List<Integer> rightSmallerThan(List<Integer> array) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            int k = i + 1;
            int j = array.size() - 1;
            int count = 0;
            while (k <= j) {
                Integer k1 = array.get(k);
                Integer i1 = array.get(i);
                Integer j1 = array.get(j);

                if (k1 < i1) {
                    count++;
                }
                if (j1 < i1 && k != j) {
                    count++;
                }
                j--;
                k++;
            }
            result.add(count);
        }
        return result;
    }
}
