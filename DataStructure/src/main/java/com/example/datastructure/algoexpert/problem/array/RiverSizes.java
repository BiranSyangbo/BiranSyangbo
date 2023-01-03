package com.example.datastructure.algoexpert.problem.array;

import java.util.ArrayList;
import java.util.List;

public class RiverSizes {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0}
        };
//        System.out.println(riverSizes(matrix));

        int s = 10;
        System.out.println( -4 * -4);;
    }

    public static List<Integer> riverSizes(int[][] matrix) {
        int v = matrix.length;
        int e = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < e; j++) {
                if (matrix[i][j] == 1)
                    ans.add(countNoOfRiver(matrix, i, j, count));
            }
        }
        return ans;
    }

    static int countNoOfRiver(int[][] matrix, int i, int j, int count) {
        if (i < 0 || i == matrix.length || j < 0 || j == matrix[i].length) return 0;
        if (matrix[i][j] == 0) return 0;

        int left = countNoOfRiver(matrix, i, j - 1, count);
        int right = countNoOfRiver(matrix, i, j + 1, count);
        int up = countNoOfRiver(matrix, i - 1, j, count);
        int down = countNoOfRiver(matrix, i + 1, j, count);

        count += right + left + up + down;
        count++;
        return count;
    }
}
