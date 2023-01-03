package com.example.datastructure.algoexpert.problem.array;

import java.util.*;

public class LineThroughPoints {

    public static int lineThroughPoints(int[][] points) {
        Map<Integer, Integer> overlap = new HashMap<>();
        int maxoverlap = 0;
        for (int i = 0; i < points.length; i++) {
            int[] points1 = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] points2 = points[j];
                int point = (points2[0] - points1[0]) == 0 ? 0 : (points2[1] - points1[1]) / (points2[0] - points1[0]);
                int max;
                if (overlap.containsKey(point)) {
                    max = overlap.get(point) + 1;
                } else
                    max = 1;
                overlap.put(point, max);
                maxoverlap = Math.max(maxoverlap, max);
            }
        }
        return maxoverlap;
    }

    public int[] answerQueries(int[] nums, int[] queries) {
        int[] answer = new int[queries.length];
        Map<Integer, List<Integer>> sumList = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            List<Integer> list = new ArrayList<>();
            list.add(val);
            sumList.put(val, list);
            for (int j = i + 1; j < nums.length; j++) {
                List<Integer> l = sumList.get(val);
                val += nums[j];
                sumList.put(val, l);
            }
        }
        for (int i = 0; i < queries.length; i++) {
            answer[i] = sumList.containsKey(queries[i]) ? sumList.get(queries[i]).size() : 0;
        }
        return answer;
    }
}
