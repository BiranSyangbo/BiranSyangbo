package com.example.datastructure.leetcode.problem.binarysearch;

import java.util.*;

public class DisjointIntervalDataStream {
    public static void main(String[] args) {
        SummaryRanges summary = new SummaryRanges();
        summary.addNum(1);
        summary.addNum(3);
        summary.addNum(7);
        summary.addNum(2);
        summary.addNum(6);
        summary.addNum(5);
        System.out.println(Arrays.deepToString(summary.getIntervals()));
    }
}

class SummaryRanges {
    SortedSet<Integer> number;

    public SummaryRanges() {
        number = new TreeSet<>();
        number.add(Integer.MAX_VALUE);
    }

    public void addNum(int value) {
        number.add(value);
    }

    public int[][] getIntervals() {
        List<int[]> intervals = new ArrayList<>();
        int start = number.first();

        ArrayList<Integer> list = new ArrayList<>(number);
        for (int i = 1; i < number.size(); i++) {
            if (list.get(i - 1) + 1 == list.get(i))
                continue;
            if (start == list.get(i)) {
                intervals.add(new int[]{start, start});
            } else {
                intervals.add(new int[]{start, list.get(i - 1)});
                start = list.get(i);
            }
        }
        return intervals.toArray(new int[1][1]);
    }
}