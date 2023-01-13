package com.example.datastructure.graph;

import java.util.*;

// 1443. Minimum Time to Collect All Apples in a Tree
public class MinimumTimeToCollect {

    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> parent = new HashMap<>();
        for (int[] edge : edges) {
            parent.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]);
            parent.computeIfAbsent(edge[1], v -> new ArrayList<>()).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        return dfs(parent, 0, hasApple, visited);
    }

    private static int dfs(Map<Integer, List<Integer>> edges, int i, List<Boolean> hasApple, boolean[] visited) {
        int totalTime = 0;
        if (!visited[i] && edges.containsKey(i)) {
            visited[i] = true;
            int count = 0;
            for (int edge : edges.get(i)) {
                count += dfs(edges, edge, hasApple, visited);
            }
            if (i == 0)
                return count;
            if (count > 0 || hasApple.get(i)) {
                totalTime += count + 2;
            }
        }
        return totalTime;
    }

    public static int minTime1(int n, int[][] edges, List<Boolean> hasApple) {
        int[] parent = new int[n];
        Arrays.fill(parent, -2);
        parent[0] = -1;
        for (int[] edge : edges) {
            if (parent[edge[0]] == -2) {
                parent[edge[0]] = edge[1];
            } else {
                parent[edge[1]] = edge[0];
            }
        }
        int total = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < hasApple.size(); i++) {
            int node = i;
            if (hasApple.get(node)) {
                while (node != 0 && !visited[node]) {
                    visited[node] = true;
                    node = parent[node];
                    total += 2;
                }
            }
        }
        return total;
    }
}
