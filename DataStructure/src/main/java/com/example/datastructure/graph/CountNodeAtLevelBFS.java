package com.example.datastructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class CountNodeAtLevelBFS {

    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();
        int size = 6;
        boolean[] visited = new boolean[size];
        int count = 2;
        queue.add(0);
        int a = bfs(getGraphs(size), visited, count, queue);
        System.out.println(a);
    }

    private static int bfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int count, LinkedList<Integer> queue) {
        LinkedList<Integer> countLevel = new LinkedList<>();
        int c = 0;
        while (!queue.isEmpty()) {
            Integer i = queue.pop();
            if (!visited[i]) {
                visited[i] = true;
                countLevel.addAll(adj.get(i));
            }
            if (queue.isEmpty() && !countLevel.isEmpty()) {
                c++;
                while (!countLevel.isEmpty()) {
                    queue.add(countLevel.pop());
                }
            }
            if (count == c) {
                break;
            }
        }
        return queue.size();
    }

    static ArrayList<ArrayList<Integer>> getGraphs(int size) {
        Graph graph = new Graph(size);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        return graph.getGraphs();
    }
}
