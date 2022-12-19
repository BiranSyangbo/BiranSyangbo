package com.example.datastructure.graph.algorithm;

import com.example.datastructure.graph.Graph;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajuAlgorithm {

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        int kosaraju = new KosarajuAlgorithm()
                .kosaraju(5, graph.getGraphs());
        System.out.println(kosaraju);
    }


    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, stack, visited);
            }
        }

        ArrayList<ArrayList<Integer>> reverse = reverse(V, adj);
        visited = new boolean[V];
        int count = 0;
        while (!stack.isEmpty()) {
            int val = stack.pop();
            if (!visited[val]) {
                Stack<Integer> stack1 = new Stack<>();
                dfsUtils(val, reverse, visited, stack1);
                System.out.println();
                if (!stack1.isEmpty()) {
                    count++;
                }
            }
        }
        return count;

    }

    void dfsUtils(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[i] = true;
        stack.push(i);
        System.out.print(i + " ");
        for (Integer element : adj.get(i)) {
            if (!visited[element]) {
                dfsUtils(element, adj, visited, stack);
            }
        }
    }

    void dfs(int i, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack, boolean[] visited) {
        visited[i] = true;
        for (Integer element : adj.get(i)) {
            if (!visited[element]) {
                dfs(element, adj, stack, visited);
            }
        }
        stack.push(i);
    }

    ArrayList<ArrayList<Integer>> reverse(int v, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> reverse = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            reverse.add(new ArrayList<>());
        }
        for (int i = 0; i < v; i++) {
            for (Integer element : adj.get(i)) {
                reverse.get(element).add(i);
            }
        }
        return reverse;
    }
}


