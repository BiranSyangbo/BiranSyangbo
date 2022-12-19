package com.example.datastructure.graph.algorithm;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Dijktra {

    public static void main(String args[]) throws IOException {

        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }

            int i = 0;
            while (i++ < E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }

            int S = Integer.parseInt(read.readLine());

            int[] ptr = dijkstra(V, adj, S);

            for (i = 0; i < V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }

    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[S] = 0;
        boolean visited[] = new boolean[V];
        Queue<Integer[]> queue = new ArrayDeque<>();
        queue.add(new Integer[]{S, 0});
        while (!queue.isEmpty()) {
            Integer[] currentVertex = queue.poll();
            Integer vertex = currentVertex[0]; // 0
            visited[vertex] = true;
            for (ArrayList<Integer> edge : adj.get(vertex)) {
                int currentEdge = edge.get(0);
                int currentEdgeDistance = edge.get(1);
                int distance = dist[vertex] + currentEdgeDistance;
                if (dist[currentEdge] > distance) {
                    queue.add(new Integer[]{currentEdge, distance});
                    dist[currentEdge] = distance;
                }
            }
        }
        return dist;
    }
}
