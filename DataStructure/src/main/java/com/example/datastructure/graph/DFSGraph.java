package com.example.datastructure.graph;

import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DFSGraph {

    public static void main(String[] args) throws IOException {
        File file = ResourceUtils.getFile("classpath:graph/dfs.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            int T = Integer.parseInt(br.readLine().trim());
            while (T-- > 0) {
                String[] s = br.readLine().trim().split(" ");
                int V = Integer.parseInt(s[0]);
                int E = Integer.parseInt(s[1]);
                ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
                for (int i = 0; i < V; i++) adj.add(new ArrayList<Integer>());
                for (int i = 0; i < E; i++) {
                    String[] S = br.readLine().trim().split(" ");
                    int u = Integer.parseInt(S[0]);
                    int v = Integer.parseInt(S[1]);
                    adj.get(u).add(v);
                    adj.get(v).add(u);
                }
                ArrayList<Integer> ans = dfsGraph(V, adj);
                for (Integer an : ans)
                    System.out.print(an + " ");
                System.out.println();
            }
        }
    }

    private static ArrayList<Integer> dfsGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> visitedList = new ArrayList<>();
        boolean[] visited = new boolean[v];
        return dfs(0, adj, visited, visitedList);

    }

    private static ArrayList<Integer> dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> visitedList) {
        if (!visited[v]) {
            visited[v] = true;
            visitedList.add(v);
            for (Integer integer : adj.get(v)) {
                dfs(integer, adj, visited, visitedList);
            }
        }
        return visitedList;
    }

}
