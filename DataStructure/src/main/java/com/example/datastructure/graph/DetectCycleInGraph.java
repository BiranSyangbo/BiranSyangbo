package com.example.datastructure.graph;

import java.util.ArrayList;

public class DetectCycleInGraph {

    public static void main(String[] args) {
        int size = 4;
        Graph graph = new Graph(size);
//        graph.addEdge(1, 2);
//        graph.addEdge(4, 2);
//        graph.addEdge(3, 2);
//        graph.addEdge(2, 1);
//        graph.addEdge(2, 3);
//        graph.addEdge(2, 4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,0);
        graph.addEdge(1,2);
        graph.addEdge(2,1);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        DetectCycleInGraph detectCycleInGraph = new DetectCycleInGraph();
        boolean cyclic = detectCycleInGraph.isCyclic(graph.getSize(), graph.getGraphs());
        System.out.println(cyclic);
    }

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] recVertex = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (cyclicUtils(i, adj, visited, recVertex, i)) {
                return true;
            }
        }
        return false;
    }

    public boolean cyclicUtils(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] recVertex, int parentNode) {
        if (recVertex[i]) {
            return true;
        }
        if (visited[i]) {
            return false;
        }

        visited[i] = true;
        recVertex[i] = true;

        for (Integer integer : adj.get(i)) {
            if (parentNode != integer)
                if (cyclicUtils(integer, adj, visited, recVertex, i)) {
                    return true;
                }
        }
        recVertex[i] = false;
        return false;
    }
}

