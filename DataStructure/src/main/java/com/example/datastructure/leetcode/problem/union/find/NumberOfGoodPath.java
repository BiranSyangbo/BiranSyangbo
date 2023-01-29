package com.example.datastructure.leetcode.problem.union.find;

import org.apache.el.lang.EvaluationContext;

import java.util.*;
import java.util.stream.IntStream;

public class NumberOfGoodPath {

    public static int numberOfGoodPaths(int[] vals, int[][] edges) {
        if (vals.length == 0)
            return 0;
        if (edges.length == 0)
            return vals.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.compute(edge[0], (k, v) -> graph.getOrDefault(k, new ArrayList<>())).add(edge[1]);
            graph.compute(edge[1], (k, v) -> graph.getOrDefault(k, new ArrayList<>())).add(edge[0]);
        }
        int n = vals.length;
        int count = n;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (vals[i] == vals[j]) {
                    boolean[] visited = new boolean[n];
                    count += dfs(i, j, visited, graph, vals, i, 0);
                }
            }
        }
        return count;
    }

    static int dfs(int start, int end, boolean[] visited, Map<Integer, List<Integer>> graph, int[] vals, int node, int count) {
        if (!visited[node]) {
            if (node == end && vals[node] == vals[end])
                count++;
            visited[node] = true;
            List<Integer> edges = graph.get(node);
            for (Integer edge : edges) {
                if (vals[edge] <= vals[start]) {
                    count = dfs(start, end, visited, graph, vals, edge, count);
                }
            }
        }
        return count;
    }

    public static int numberOfGoodPaths1(int[] vals, int[][] edges) {
        if (vals.length == 0)
            return 0;
        if (edges.length == 0)
            return vals.length;

        int n = vals.length;
        Map<String, Integer> valMap = new HashMap<>();
        int[] graph = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = i;
            int val = vals[i];
            String key = i + ":" + val;
            valMap.put(key, val);
        }
        for (int[] edge : edges) {
            union(graph, edge[0], edge[1]);
        }

        int path = n;
        for (int i = 0; i < vals.length; i++) {
            for (int j = 1; j < n; j++) {
                if (vals[i] == vals[j]) {

                }
            }
        }

        return 0;
    }

    static void union(int[] graph, int start, int end) {
        start = find(graph, start);
        end = find(graph, end);
        graph[start] = end;
    }

    static int find(int[] graph, int node) {
        if (graph[node] == node)
            return node;
        return graph[node] = find(graph, graph[node]);
    }


}

class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++)
            parent[i] = i;
        rank = new int[size];
    }

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union_set(int x, int y) {
        int xset = find(x), yset = find(y);
        if (xset == yset) {
            return;
        } else if (rank[xset] < rank[yset]) {
            parent[xset] = yset;
        } else if (rank[xset] > rank[yset]) {
            parent[yset] = xset;
        } else {
            parent[yset] = xset;
            rank[xset]++;
        }
    }
}

class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            adj.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
            adj.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
        }

        int n = vals.length;
        // Mapping from value to all the nodes having the same value in sorted order of
        // values.
        TreeMap<Integer, List<Integer>> valuesToNodes = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            valuesToNodes.computeIfAbsent(vals[i], value -> new ArrayList<Integer>()).add(i);
        }

        UnionFind dsu = new UnionFind(n);
        int goodPaths = 0;

        // Iterate over all the nodes with the same value in sorted order, starting from
        // the lowest value.
        for (int value : valuesToNodes.keySet()) {
            // For every node in nodes, combine the sets of the node and its neighbors into
            // one set.
            for (int node : valuesToNodes.get(value)) {
                if (!adj.containsKey(node))
                    continue;
                for (int neighbor : adj.get(node)) {
                    // Only choose neighbors with a smaller value, as there is no point in
                    // traversing to other neighbors.
                    if (vals[node] >= vals[neighbor]) {
                        dsu.union_set(node, neighbor);
                    }
                }
            }
            // Map to compute the number of nodes under observation (with the same values)
            // in each of the sets.
            Map<Integer, Integer> group = new HashMap<>();
            // Iterate over all the nodes. Get the set of each node and increase the count
            // of the set by 1.
            for (int u : valuesToNodes.get(value)) {
                group.put(dsu.find(u), group.getOrDefault(dsu.find(u), 0) + 1);
            }
            // For each set of "size", add size * (size + 1) / 2 to the number of goodPaths.
            for (int key : group.keySet()) {
                int size = group.get(key);
                goodPaths += size * (size + 1) / 2;
            }
        }
        return goodPaths;
    }
}
