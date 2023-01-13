package com.example.datastructure.algoexpert.problem.array;

import java.util.*;

import static com.example.datastructure.math.GreatestCommonDivisor.gcd;

public class LineThroughPoints {

    public static int lineThroughPoints(int[][] points) {
        int maxoverlap = 1;
        for (int i = 0; i < points.length; i++) {
            int[] points1 = points[i];
            Map<String , Integer> overlap = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                int[] points2 = points[j];
                String slope = slop(points1, points2);
                //(double) (points2[1] - points1[1]) / (points2[0] - points1[0]);
                overlap.compute(slope, (k, v) -> overlap.getOrDefault(k, 1) + 1);
                maxoverlap = Math.max(maxoverlap, overlap.get(slope));
            }
        }
        return maxoverlap;
    }

    private static String slop(int[] point1, int[] point2) {
        int x1 = point1[0];
        int y1 = point1[1];
        int x2 = point2[0];
        int y2 = point2[1];
        String slop = "1:0";
        if (x1 != x2) {
            int xDiff = x2 - x1;
            int yDiff = y2 - y1;
            int gcd = gcd(xDiff, yDiff);
            xDiff = xDiff / gcd;
            yDiff = yDiff / gcd;
            if (xDiff < 0) {
                xDiff *= -1;
                yDiff *= -1;
            }
            slop = xDiff + ":" + yDiff;
        }
        return slop;
    }
    public int abc(){
        while (true) {
            return 1;
        }
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
