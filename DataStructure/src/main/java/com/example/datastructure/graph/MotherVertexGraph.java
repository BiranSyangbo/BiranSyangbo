package com.example.datastructure.graph;

import java.util.ArrayList;

public class MotherVertexGraph {

    public static void main(String[] args) {
        int size = 5;
        Graph graph = new Graph(size);

//        graph.addEdge(5,2);
//        graph.addEdge(5,6);
//        graph.addEdge(6,4);
//        graph.addEdge(6,0);
//        graph.addEdge(0,1);
//        graph.addEdge(0,2);
//        graph.addEdge(1,3);
//        graph.addEdge(4,1);

        graph.addEdge(0, 2);
        graph.addEdge(1, 0);
        graph.addEdge(2, 1);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);

        System.out.println(motherVet(size, graph.getGraphs()));
    }

    private static ArrayList<Integer> motherVertex(int size, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            boolean[] visited = new boolean[size];
            int count = 0;
            dfs(i, adj, visited);
            for (int j = 0; j < size; j++) {
                if (!visited[j])
                    break;
                else
                    count++;
            }
            if (count == size)
                integers.add(i);
        }
        return integers;
    }

    private static void dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[i] = true;
        for (Integer element : adj.get(i)) {
            if (!visited[element]) {
                dfs(element, adj, visited);
            }
        }
    }

    // Article Solution
    private static int motherVet(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[v];
        int lastV = -1;
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited);
                lastV = i;
            }
        }

        visited = new boolean[v];
        dfs(lastV, adj, visited);

        for (int i = 0; i < v; i++) {
            if (!visited[i])
                return -1;
        }

        return lastV;
    }

}
