package com.example.datastructure.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class TopologicalSort1 {

    public static void main(String[] args) {
        int size = 8;
        Graph graph = new Graph(size);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 6);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(3, 6);
        graph.addEdge(4, 7);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
        System.out.println(Arrays.toString(topological(size, graph.getGraphs())));
    }

    private static int[] topological(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[v];
        int i = v - 1;
        int[] arr = new int[v];
        for (int at = 0; at < v; at++) {
            if (!visited[at]) {
                i = dfs(i, at, visited, arr, adj);
            }
        }
        return arr;
    }

    private static int dfs(int i, int at, boolean[] visited, int[] arr, ArrayList<ArrayList<Integer>> adj) {
        visited[at] = true;
        for (Integer elements : adj.get(at)) {
            if (!visited[elements]) {
                i = dfs(i, elements, visited, arr, adj);
            }
        }
        arr[i] = at;
        return i - 1;
    }
}
