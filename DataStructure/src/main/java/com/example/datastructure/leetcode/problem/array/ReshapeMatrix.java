package com.example.datastructure.leetcode.problem.array;

public class ReshapeMatrix {
    public static void main(String[] args) {

    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] arr = new int[r][c];
        int k = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                int v = mat[i][j];
                for (int m = 0; i < c / r; m++) {
                    arr[k][m] = v;
                }
                k++;
            }
        }
        return arr;

    }
}
