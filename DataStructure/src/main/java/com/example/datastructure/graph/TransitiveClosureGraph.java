package com.example.datastructure.graph;

//TODO Failed
public class TransitiveClosureGraph {

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0, 1},
                {0, 1, 1, 0},
                {0, 0, 1, 1},
                {0, 0, 0, 1}};
        findTransitiveGraph(arr, 4);

    }


    public static void findTransitiveGraph(int[][] adj, int V) {
        int[][] visited = new int[V][V];
        for (int i = 0; i < V; i++) {
            processTransitive(i, i, adj, visited);
        }

        for (int[] ints : visited) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    static void processTransitive(int v, int i, int[][] adj, int[][] visited) {
        visited[v][i] = 1;
        for (int j = 0; j < adj.length; j++) {
            if (visited[v][j] == 0 && adj[v][j] == 1) {
                processTransitive(v, j, adj, visited);
            }
        }
    }
}
