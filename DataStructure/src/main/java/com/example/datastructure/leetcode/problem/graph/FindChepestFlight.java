package com.example.datastructure.leetcode.problem.graph;

import java.util.*;

public class FindChepestFlight {


    public static void main(String[] args) {
        int j = 0;
    }

    // There is an issue
    public static int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], key -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }
        int[] dest = new int[n];
        Arrays.fill(dest, Integer.MAX_VALUE);
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{src, 0, k});
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            int s = pop[0];
            int d = pop[1];
            int c = pop[2];
            if (s == dst)
                continue;
            if (c < 0)
                continue;
            List<int[]> g = graph.getOrDefault(s, new ArrayList<>());
            for (int[] ints : g) {
                int newSrc = ints[0];
                int newDest = ints[1];
                if (dest[newSrc] > d + newDest) {
                    dest[newSrc] = d + newDest;
                    stack.push(new int[]{newSrc, d + newDest, c - 1});
                }
            }
        }
        return dest[dst] == Integer.MAX_VALUE ? -1 : dest[dst];
    }


    // bellmon ford examples
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(dist, dist.length);
            for (int[] flight : flights) {
                int s = flight[0], d = flight[1], c = flight[2];
                if (dist[s] == Integer.MAX_VALUE) continue;
                temp[d] = Math.min(temp[d], dist[s] + c);
            }
            dist = temp;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }


}
