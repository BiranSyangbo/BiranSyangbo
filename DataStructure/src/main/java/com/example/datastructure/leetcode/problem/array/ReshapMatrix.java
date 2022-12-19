package com.example.datastructure.leetcode.problem.array;

import java.util.Arrays;

public class ReshapMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {3, 4}};
        System.out.println(Arrays.toString(reshape(arr, 1, 4)));
    }

    public static int[][] reshape(int[][] mat, int r, int c) {
        int mr = mat.length;
        int mc = mat[0].length;
        if ((mr * mc) != (r * c)) {
            return mat;
        }
        int[][] arr = new int[r][c];

        for (int i = 0; i < (r * c); i++) {
            arr[i / c][i % c] = mat[i / mc][i % mc];
        }
        return arr;
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] arr = new int[r][c];
        int k = 0;
        int m = 0;
        int len = mat.length * mat[0].length;
        if (len != (r * c))
            return mat;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = mat[k][m];
                if (m < mat[0].length - 1) {
                    m++;
                } else {
                    k++;
                    m = 0;
                }
            }
        }


        return arr;
    }
}
