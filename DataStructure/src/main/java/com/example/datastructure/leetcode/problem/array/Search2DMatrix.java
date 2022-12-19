package com.example.datastructure.leetcode.problem.array;

//74. Search a 2D Matrix
public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}};
        System.out.println(exist(arr, 3));

    }

    public static boolean exist(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target)
                    return true;
            }
        }
        return false;
    }
}
