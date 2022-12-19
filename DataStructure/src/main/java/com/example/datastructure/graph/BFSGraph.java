package com.example.datastructure.graph;

import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

public class BFSGraph {

    public static void main(String[] args) throws IOException {
        File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "graph/bfs.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            int T = Integer.parseInt(br.readLine().trim());
            while (T-- > 0) {
                String[] s = br.readLine().trim().split(" ");
                int V = Integer.parseInt(s[0]);
                int E = Integer.parseInt(s[1]);
                ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
                for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
                for (int i = 0; i < E; i++) {
                    String[] S = br.readLine().trim().split(" ");
                    int u = Integer.parseInt(S[0]);
                    int v = Integer.parseInt(S[1]);
                    adj.get(u).add(v);
                    // adj.get(v).add(u);
                }
                System.out.println(bfsGraph(V, adj));
            }
        }
    }

    private static ArrayList<Integer> bfsGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> bfs = new ArrayDeque<>();
        ArrayList<Integer> bf = new ArrayList<>();
        boolean[] visited = new boolean[v];
        int s = 0;
        visited[s] = true;
        bfs.add(s);
        while (bfs.size() != 0) {
            s = bfs.poll();
            bf.add(s);
            for (Integer integer : adj.get(s)) {
                if (!visited[integer]) {
                    visited[integer] = true;
                    bfs.add(integer);
                }
            }
        }
        return bf;
    }
}