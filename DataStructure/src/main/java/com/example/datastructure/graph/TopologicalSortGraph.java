package com.example.datastructure.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class TopologicalSortGraph {

    public static void main(String[] args) {
        int size = 8;
        Graph graph = new Graph(size);
//        graph.addEdge(0, 1);
//        graph.addEdge(1, 4);
//        graph.addEdge(4, 0);
//        graph.addEdge(4, 3);
//        graph.addEdge(3, 1);
//        graph.addEdge(3, 4);
//        graph.addEdge(1, 2);
//        graph.addEdge(2, 3);
//        graph.addEdge(2, 5);
//        graph.addEdge(5, 6);
//        graph.addEdge(6, 7);
//        graph.addEdge(7, 5);


//        graph.addEdge(5, 0);
//        graph.addEdge(5, 2);
//        graph.addEdge(4, 0);
//        graph.addEdge(4, 1);
//        graph.addEdge(2, 3);
//        graph.addEdge(3, 1);
//
//        graph.addEdge(0, 1);
//        graph.addEdge(0, 2);
//        graph.addEdge(1, 2);
//        graph.addEdge(1, 3);
//        graph.addEdge(3, 2);
//        graph.addEdge(3, 4);
//        graph.addEdge(2, 4);

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

        topologicalSort(size, graph.getGraphs());


    }

    private static void topologicalSort(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < v; i++) {
            dfs(i, adj, visited, stack);
        }
        for (int i = 0; i < v; i++) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static void dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        if (!visited[i]) {
            visited[i] = true;
            Iterator<Integer> iterator = adj.get(i).iterator();
            iterator.forEachRemaining(element -> {
                dfs(element, adj, visited, stack);
            });
            stack.push(i);
        }
    }

}
