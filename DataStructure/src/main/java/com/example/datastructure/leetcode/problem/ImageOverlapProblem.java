package com.example.datastructure.leetcode.problem;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageOverlapProblem {

    public static void main(String[] args) throws ParseException {
        int[][] img1 = {{1, 1, 0}, {0, 1, 0}, {0, 1, 0}};
//        int[][] img1 = {{0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        int[][] img2 = {{0, 0, 0}, {0, 1, 1}, {0, 0, 1}};
//        int[][] img2 = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}};
//        largestOverlap(img1, img2);
        System.out.println(largestOverlap(img1, img2));

    }


    public static int shiftAndCountApproach(int[][] img1, int[][] img2) {
        int maxOverlaped = 0;
        for (int yShift = 0; yShift < img1.length; yShift++) {
            for (int xShift = 0; xShift < img1.length; xShift++) {
                maxOverlaped = Math.max(maxOverlaped, shiftAndCount(xShift, yShift, img1, img2));
                maxOverlaped = Math.max(maxOverlaped, shiftAndCount(xShift, yShift, img2, img1));
            }
        }
        return maxOverlaped;
    }

    public static int shiftAndCount(int xShift, int yShift, int[][] M, int[][] R) {
        int leftShiftCount = 0, rightShiftCount = 0;
        int rRow = 0;
        for (int mRow = yShift; mRow < M.length; mRow++) {
            int rCol = 0;
            for (int mCol = xShift; mCol < M.length; mCol++) {
                if (M[mRow][mCol] == 1 && M[mRow][mCol] == R[rRow][rCol])
                    leftShiftCount++;
                if (M[mRow][rCol] == 1 && M[mRow][rCol] == R[rRow][mCol])
                    rightShiftCount++;
                rCol++;
            }
            rRow++;
        }
        return Math.max(leftShiftCount, rightShiftCount);
    }


    public static Integer linearTransformationImageOverlap(int[][] img1, int[][] img2) {
        List<Pair<Integer, Integer>> pairWithNoneZer_A = pairWithNoneZer(img1);
        List<Pair<Integer, Integer>> pairWithNoneZer_B = pairWithNoneZer(img2);
        int maxOverlap = 0;
        Map<Pair<Integer, Integer>, Integer> groupCount = new HashMap<>();
        for (Pair<Integer, Integer> pair_A : pairWithNoneZer_A) {
            for (Pair<Integer, Integer> pair_B : pairWithNoneZer_B) {
                Pair<Integer, Integer> g = new Pair<>(pair_B.getKey() - pair_A.getKey(), pair_B.getValue() - pair_A.getValue());
                if (groupCount.containsKey(g)) {
                    groupCount.put(g, groupCount.get(g) + 1);
                } else {
                    groupCount.put(g, 1);
                }
                maxOverlap = Math.max(maxOverlap, groupCount.get(g));
            }
        }
        return maxOverlap;
    }

    public static List<Pair<Integer, Integer>> pairWithNoneZer(int[][] img) {
        List<Pair<Integer, Integer>> pair = new ArrayList<>();

        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img.length; j++) {
                if (img[i][j] == 1) {
                    pair.add(new Pair<>(i, j));
                }
            }
        }
        return pair;
    }


    // Copy Paste From Solution
    protected static int convolute(int[][] A, int[][] kernel, int xShift, int yShift) {
        int result = 0;
        for (int row = 0; row < A.length; ++row)
            for (int col = 0; col < A.length; ++col)
                result += A[row][col] * kernel[row + yShift][col + xShift];
        return result;
    }

    public static int largestOverlap(int[][] A, int[][] B) {

        int N = A.length;
        int[][] B_padded = new int[3 * N - 2][3 * N - 2];
        for (int row = 0; row < N; ++row)
            for (int col = 0; col < N; ++col)
                B_padded[row + N - 1][col + N - 1] = B[row][col];

        int maxOverlaps = 0;
        for (int xShift = 0; xShift < 2 * N - 1; ++xShift)
            for (int yShift = 0; yShift < 2 * N - 1; ++yShift) {
                maxOverlaps = Math.max(maxOverlaps,
                        convolute(A, B_padded, xShift, yShift));
            }

        return maxOverlaps;
    }


    private static class Pair<T, V> {
        private T key;
        private V value;

        Pair(T key, V value) {
            this.key = key;
            this.value = value;
        }

        public T getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
