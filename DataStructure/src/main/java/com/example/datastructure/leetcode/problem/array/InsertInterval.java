package com.example.datastructure.leetcode.problem.array;

import com.sun.nio.sctp.PeerAddressChangeNotification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {


    /**
     * My solution
     * Merge {@param intervals} and {@param newInterval} array
     * Sorting the new array with index 0;
     * check currentInterval is overlap with next if yes merge two of them else copy unique combination to next position
     */
    public static int[][] insert1(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0)
            return new int[][]{newInterval};
        if (newInterval.length == 0)
            return intervals;
        int[][] modified = new int[intervals.length + 1][newInterval.length];
        System.arraycopy(intervals, 0, modified, 0, intervals.length);
        modified[modified.length - 1] = newInterval;
        Arrays.sort(modified, Comparator.comparingInt(o -> o[0]));
        int i = 1;
        int j = 0;
        while (i < modified.length) {
            if (modified[j][1] < modified[i][0]) {
                modified[++j] = modified[i];
            } else {
                int min = Math.min(modified[j][0], modified[i][0]);
                int max;
                if (modified[i][1] > modified[j][1]) {
                    max = modified[i][1];
                } else {
                    max = modified[j][1];
                }
                modified[j] = new int[]{min, max};
            }
            i++;
        }
        return Arrays.copyOfRange(modified, 0, j + 1);
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0)
            return new int[][]{newInterval};
        if (newInterval.length == 0)
            return intervals;
        int[][] modified = mergeInterval(intervals, newInterval);
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < modified.length; i++) {
            int[] interval = {modified[i][0], modified[i][1]};
            while (i < modified.length && doesOverlap(interval, modified[i])) {
                interval = mergeOverlapInterval(interval, modified[i]);
                i++;
            }
            i--;
            ans.add(interval);
        }
        return ans.toArray(new int[ans.size()][newInterval.length]);
    }

    private static int[] mergeOverlapInterval(int[] a, int[] b) {
        int[] newInterval = {Math.min(a[0], b[0]), Math.max(a[1], b[1])};
        return newInterval;
    }

    private static boolean doesOverlap(int[] interval, int[] newInterval) {
        return (Math.min(interval[1], newInterval[1]) - Math.max(interval[0], newInterval[0])) >= 0;
    }

    static int[][] mergeInterval(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new ArrayList<>(Arrays.asList(intervals));
        int index = findPosition(intervals, newInterval);
        merged.add(index, newInterval);
        return merged.toArray(new int[merged.size()][newInterval.length]);
    }

    static int findPosition(int[][] intervals, int[] newInterval) {
        int start = 0;
        int end = intervals.length - 1;
        int ans = intervals.length;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (intervals[mid][0] > newInterval[0]) {
                ans = mid;
                end = mid - 1;
            } else
                start = mid + 1;
        }
        return ans;
    }
}
