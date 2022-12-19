package com.example.datastructure.graph;

import java.util.ArrayList;

public class Graph {
    private ArrayList<ArrayList<Integer>> adj;

    private final int size;

    public Graph(int v) {
        this.size = v;
        this.adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public int getSize() {
        return size;
    }

    public void addEdge(int source, int dest) {
        adj.get(source).add(dest);
    }

    public ArrayList<ArrayList<Integer>> getGraphs() {
        return adj;
    }
}
