package com.example.datastructure.graph;

import java.util.ArrayList;
import java.util.Stack;

public class StronglyConnectedComponentGraph {

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        scc(5, graph.getGraphs(), 0);
    }

    private static void scc(int v, ArrayList<ArrayList<Integer>> adj, int start) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs(start, adj, stack, visited);
            }
        }
        Graph reverse = reverse(v, adj);
        visited = new boolean[v];
        while (!stack.isEmpty()) {
            int i = stack.pop();
            if (!visited[i]) {
                dfsUtils(i, visited, reverse.getGraphs());
                System.out.println();
            }
        }
    }

    private static void dfs(int i, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack, boolean[] visited) {
        visited[i] = true;
        for (Integer element : adj.get(i)) {
            if (!visited[element]) {
                dfs(element, adj, stack, visited);
            }
        }
        stack.push(i);
    }

    private static void dfsUtils(int v, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[v] = true;
        System.out.print(v + " ");
        for (Integer element : adj.get(v)) {
            if (!visited[element]) {
                dfsUtils(element, visited, adj);
            }
        }
    }

    private static Graph reverse(int v, ArrayList<ArrayList<Integer>> adj) {
        Graph graph = new Graph(v);
        for (int i = 0; i < v; i++) {
            for (Integer element : adj.get(i)) {
                graph.addEdge(element, i);
            }
        }
        return graph;
    }


}
