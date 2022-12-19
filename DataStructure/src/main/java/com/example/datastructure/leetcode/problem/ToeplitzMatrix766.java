package com.example.datastructure.leetcode.problem;

public class ToeplitzMatrix766 {
    public static void main(String[] args) {
        int[][] arr = { {1,2}, {2,2}};
        for (int i : arr[0]) {
            
        }
        System.out.println(isToeplitzMatrix(arr));
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
