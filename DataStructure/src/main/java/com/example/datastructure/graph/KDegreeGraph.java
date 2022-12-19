package com.example.datastructure.graph;

import java.util.ArrayList;

public class KDegreeGraph {

    public static void main(String[] args) {
        Graph graph = new Graph(9);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(1, 5);
        graph.addEdge(2, 1);
        graph.addEdge(2, 0);
        graph.addEdge(2, 5);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 6);
        graph.addEdge(3, 2);
        graph.addEdge(3, 4);
        graph.addEdge(3, 6);
        graph.addEdge(3, 7);
        graph.addEdge(4, 2);
        graph.addEdge(4, 6);
        graph.addEdge(4, 3);
        graph.addEdge(4, 7);
        graph.addEdge(5, 1);
        graph.addEdge(5, 2);
        graph.addEdge(5, 6);
        graph.addEdge(5, 8);
        graph.addEdge(6, 2);
        graph.addEdge(6, 3);
        graph.addEdge(6, 4);
        graph.addEdge(6, 5);
        graph.addEdge(6, 7);
        graph.addEdge(6, 8);
        graph.addEdge(7, 4);
        graph.addEdge(7, 3);
        graph.addEdge(7, 6);
        graph.addEdge(8, 5);
        graph.addEdge(8, 6);

        Graph g2 = new Graph(13);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(0, 3);
        g2.addEdge(1, 4);
        g2.addEdge(1, 5);
        g2.addEdge(1, 6);
        g2.addEdge(2, 7);
        g2.addEdge(2, 8);
        g2.addEdge(2, 9);
        g2.addEdge(3, 10);
        g2.addEdge(3, 11);
        g2.addEdge(3, 12);

        new KDegreeGraph().getGraph(g2.getGraphs(), g2.getSize(), 3);
    }

    public void getGraph(ArrayList<ArrayList<Integer>> adj, int v, int k) {
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            dfs(adj, i, k, i);
        }
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, int i, int k, int v) {
        ArrayList<Integer> elements = adj.get(i);
        if (elements != null && elements.size() < k) {
            adj.set(i, null);
            for (Integer element : elements) {
                adj.get(element).remove((Integer) v);
                dfs(adj, element, k, element);
            }
        }

        System.out.println(adj);
    }
}
