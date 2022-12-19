package com.example.datastructure.graph;

import java.util.ArrayList;
import java.util.Stack;

public class RiverSizeProblem {

    public static void main(String[] args) {
        int[][] arr = {{1, 0, 1, 0},
                {0, 0, 1, 1},
                {1, 0, 0, 0}};

        ArrayList<Integer> integers = riverSize(arr);
        System.out.println(integers);
    }

    public static ArrayList<Integer> riverSize(int[][] arr) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        ArrayList<Integer> results = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, arr, visited, results);
                }
            }
        }
        return results;
    }

    private static void dfs(int i, int j, int[][] arr, boolean[][] visited, ArrayList<Integer> results) {
        Stack<int[][]> stack = new Stack<>();
        int[][] abc = {{i, j}};
        stack.push(abc);
        int count = 0;
        while (!stack.isEmpty()) {
            int[][] pop = stack.pop();
            i = pop[0][0];
            j = pop[0][1];
            if (visited[i][j]) {
                continue;
            }
            visited[i][j] = true;
            if (arr[i][j] == 0)
                continue;
            ArrayList<int[][]> newElement = getUnvisitedNode(i, j, arr, visited);
            for (int[][] ints : newElement) {
                stack.push(ints);
            }

            count++;
        }
        if (count > 0)
            results.add(count);
    }

    private static ArrayList<int[][]> getUnvisitedNode(int i, int j, int[][] arr, boolean[][] visited) {
        ArrayList<int[][]> unvisitedNode = new ArrayList<>();
        if (i > 0 && !visited[i - 1][j]) {
            unvisitedNode.add(new int[][]{{i - 1, j}});
        }
        if (i < arr.length - 1 && !visited[i + 1][j]) {
            unvisitedNode.add(new int[][]{{i + 1, j}});
        }
        if (j > 0 && !visited[i][j - 1]) {
            unvisitedNode.add(new int[][]{{i, j - 1}});
        }
        if (j < arr[0].length - 1 && !visited[i][j + 1]) {
            unvisitedNode.add(new int[][]{{i, j + 1}});
        }
        return unvisitedNode;
    }
}
