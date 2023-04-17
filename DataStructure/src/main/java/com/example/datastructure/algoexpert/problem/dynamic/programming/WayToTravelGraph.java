package com.example.datastructure.algoexpert.problem.dynamic.programming;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class WayToTravelGraph {
    public static void main(String[] args) {
        final int i = numberOfWaysToTraverseGraph(3, 4);
        System.out.println(i);
    }
    public static int numberOfWaysToTraverseGraph(int width, int height) {
        int[][] ways = new int[width + 1][height + 1];
        for (int i = 1; i <= width; i++) {
            for (int j = 1; j <= height; j++) {
                if (i == 1 || j == 1) {
                    ways[i][j] = 1;
                } else {
                    int x = ways[i - 1][j];
                    int y = ways[i][j - 1];
                    ways[i][j] = x + y;
                }
            }
        }
        return ways[width][height];
    }
}
