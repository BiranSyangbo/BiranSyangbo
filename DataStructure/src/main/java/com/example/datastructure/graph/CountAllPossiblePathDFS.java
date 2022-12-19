package com.example.datastructure.graph;

import java.util.ArrayList;

public class CountAllPossiblePathDFS {

    public static void main(String[] args) {
        int size = 25;
        ArrayList<ArrayList<Integer>> graphs = getGraphs(size);
        ArrayList<ArrayList<Integer>> transpose = transpose(size, graphs);
        boolean[] booleans = new boolean[size];
        Integer count = 0;
        count = countPath(20, 20, transpose, count);
        System.out.println(count);
    }

    static ArrayList<ArrayList<Integer>> transpose(int v, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            ans.add(new ArrayList<>());
        }
        for (int i = 0; i < v; i++) {
            for (Integer element : adj.get(i)) {
                ans.get(element).add(i);
            }
        }
        return ans;
    }

    static int countPath(int from, int to, ArrayList<ArrayList<Integer>> adj, int count) {
        if (from == to) {
            count++;
        }
        for (Integer element : adj.get(to)) {

            count = countPath(from, element, adj, count);
        }
        return count;
    }

    static ArrayList<ArrayList<Integer>> getGraphs(int size) {
        Graph graph = new Graph(size);
        graph.addEdge(24, 2);
        graph.addEdge(3, 9);
        graph.addEdge(23, 9);
        graph.addEdge(24, 9);
        graph.addEdge(23, 15);
        graph.addEdge(24, 15);
        graph.addEdge(2, 15);
        graph.addEdge(9, 15);
        graph.addEdge(24, 4);
        graph.addEdge(2, 4);
        graph.addEdge(15, 4);
        graph.addEdge(9, 17);
        graph.addEdge(4, 17);
        graph.addEdge(4, 0);
        graph.addEdge(17, 0);
        graph.addEdge(15, 13);
        graph.addEdge(4, 13);
        graph.addEdge(0, 13);
        graph.addEdge(22, 11);
        graph.addEdge(4, 11);
        graph.addEdge(17, 11);
        graph.addEdge(0, 11);
        graph.addEdge(13, 11);
        graph.addEdge(24, 14);
        graph.addEdge(17, 14);
        graph.addEdge(13, 14);
        graph.addEdge(11, 14);
        graph.addEdge(15, 21);
        graph.addEdge(13, 21);
        graph.addEdge(11, 21);
        graph.addEdge(14, 8);
        graph.addEdge(21, 8);
        graph.addEdge(3, 18);
        graph.addEdge(8, 18);
        graph.addEdge(13, 16);
        graph.addEdge(14, 16);
        graph.addEdge(21, 16);
        graph.addEdge(8, 16);
        graph.addEdge(18, 16);
        graph.addEdge(0, 20);
        graph.addEdge(11, 20);
        graph.addEdge(21, 20);
        graph.addEdge(8, 20);
        graph.addEdge(18, 20);
        graph.addEdge(15, 10);
        graph.addEdge(17, 10);
        graph.addEdge(13, 10);
        graph.addEdge(21, 10);
        graph.addEdge(18, 10);
        graph.addEdge(20, 10);
        graph.addEdge(10, 5);
        graph.addEdge(13, 12);
        graph.addEdge(11, 12);
        graph.addEdge(18, 12);
        graph.addEdge(16, 12);
        graph.addEdge(21, 6);
        graph.addEdge(12, 6);
        graph.addEdge(10, 1);
        graph.addEdge(6, 1);
        graph.addEdge(11, 7);
        graph.addEdge(10, 7);
        graph.addEdge(8, 19);
        graph.addEdge(16, 19);
        graph.addEdge(7, 19);
        return graph.getGraphs();
    }
}

