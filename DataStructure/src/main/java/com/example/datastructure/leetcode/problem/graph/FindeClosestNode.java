package com.example.datastructure.leetcode.problem.graph;

import java.util.*;

// 2359. Find Closest Node to Given Two Nodes
public class FindeClosestNode {

    public static void main(String[] args) {
        int[] nodeList = {14, 6, 6, 6, 11, 8, 15, 15, 1, 13, 17, 17, 2, 16, 15, 11, 7, 0};
        System.out.println(closestMeetingNode(nodeList, 3, 10));
    }

    public static int closestMeetingNode(int[] edges, int node1, int node2) {
        Map<Integer, Integer> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            graph.put(i, edges[i]);
        }
        int[] node1Visit = new int[edges.length];
        Arrays.fill(node1Visit, Integer.MAX_VALUE);
        dfs(graph, node1Visit, new boolean[edges.length], node1, 0);
        int[] node2Visit = new int[edges.length];
        Arrays.fill(node2Visit, Integer.MAX_VALUE);
        dfs(graph, node2Visit, new boolean[edges.length], node2, 0);
        int ans = -1;
        int lastVisitVal = Integer.MAX_VALUE;
        for (int i = 0; i < edges.length; i++) {
            if (lastVisitVal > Math.max(node1Visit[i], node2Visit[i])) {
                ans = i;
                lastVisitVal = Math.max(node1Visit[i], node2Visit[i]);
            }
        }
        return ans;

    }

    static void dfs(Map<Integer, Integer> graph, int[] nodeList, boolean[] visited, int node, int countPath) {
        if (!visited[node]) {
            visited[node] = true;
            nodeList[node] = countPath;
            node = graph.getOrDefault(node, -1);
            if (node != -1) {
                dfs(graph, nodeList, visited, node, countPath + 1);
            }
        }
    }
}
