package com.example.datastructure.graph;

import java.util.*;

// 1519. Number of Nodes in the Sub-Tree With the Same Label
public class NumberOfSameLabelSubTree {

    public static int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] edg = new int[n];
        Arrays.fill(edg, -1);
        for (int[] edge : edges) {
            edg[edge[1]] = edge[0];
        }
        int[] result = new int[n];
        Arrays.fill(result, 1);
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            int j = i;
            Map<Character, Character> holder = new HashMap<>();
            while (j != -1) {
                if (holder.containsKey(labels.charAt(j))) {
                    if (!visited[j])
                        result[j]++;
                    else
                        result[j] = result[edg[j]];
                }
                visited[j] = true;
                char ch = labels.charAt(j);
                j = edg[j];
                holder.put(ch, ch);
            }
        }
        return result;
    }

    public static int[] countSubTrees1(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> edg = new HashMap<>();
        for (int[] edge : edges) {
            edg.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            edg.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        int[] result = new int[n];
        dfs(edg, result, 0, labels, -1);
        return result;
    }

    public static int[] dfs(Map<Integer, List<Integer>> edg, int[] result, int node, String label, int parent) {
        int[] nodeCounts = new int[26];
        nodeCounts[label.charAt(node) - 'a'] = 1;
        if (edg.containsKey(node)) {
            List<Integer> edgeList = edg.get(node);
            for (Integer e : edgeList) {
                if (e == parent)
                    continue;
                int[] childCounts = dfs(edg, result, e, label, node);
                for (int i = 0; i < 26; i++) {
                    nodeCounts[i] += childCounts[i];
                }
            }
        }
        result[node] = nodeCounts[label.charAt(node) - 'a'];
        return nodeCounts;
    }

}
