package com.example.datastructure.graph;

import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PrintAdjacentList {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new FileReader(ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX+"graph/adjacentlist.txt")));
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
                adj.get(v).add(u);
            }
            ArrayList<ArrayList<Integer>> ans = printGraph(V, adj);
            for (int i = 0; i < ans.size(); i++) {
                for (int j = 0; j < ans.get(i).size() - 1; j++) {
                    System.out.print(ans.get(i).get(j) + "-> ");
                }
                System.out.print(ans.get(i).get(ans.get(i).size() - 1));
                System.out.println();
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> printGraph(
            int V, ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < V; i++) {
            adj.get(i).add(0, i);
        }
        return adj;
    }
}