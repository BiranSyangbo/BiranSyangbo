package com.example.datastructure.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class NumberOfIslandProblem {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0},
                {0, 0, 1, 1, 0, 1, 0},
                {0, 0, 1, 1, 0, 1, 0},
        };
        findAdjacent(grid, 3, 0);
    }
    public static void findAdjacent(int[][] adj, int i, int j) {  // i= 3,  j = 0;
        ArrayList<int[][]> list = new ArrayList<>();
        if (i > 0 && j== 0) {
            list.add(new int[][]{{i - 1, j}});
        }
        if (i < adj.length - 1) {
            list.add(new int[][]{{i + 1, j}});
        }

        if (j > 0) {
            list.add(new int[][]{{i, j - 1}});
        }

        if (j < adj[0].length - 1) {
            list.add(new int[][]{{i, j + 1}});
        }
        list.forEach(a -> {
            for (int[] ints : a) {
                System.out.println(Arrays.toString(ints));
            }
        });
    }


}
