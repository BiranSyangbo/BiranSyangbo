package com.example.datastructure.leetcode.problem.graph;

import java.util.*;

public class FindChepestFlight {


    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<String, Integer> priceGraph = new HashMap<>();
        for (int[] flight : flights) {
            graph.compute(flight[0],
                    (key, v) -> {
                        List<Integer> orDefault = graph.getOrDefault(key, new ArrayList<>());
                        orDefault.add(flight[1]);
                        return orDefault;
                    });
            String key = flight[0] + ":" + flight[1];
            priceGraph.put(key, flight[2]);
        }
        boolean[] visited = new boolean[n];
        int travel = searchCheapestPrice(graph, priceGraph, visited, src, dst, k, Integer.MAX_VALUE, 0, 0);
        return travel == Integer.MAX_VALUE ? -1 : travel;
    }

    static int searchCheapestPrice(Map<Integer, List<Integer>> graph, Map<String, Integer> priceGraph, boolean[] visited, int src, int dest, int k, int price, int travel, int travelPrice) {
        if (!visited[src]) {
            if (travel > k)
                return price;
            if (src == dest) {
                return Math.min(price, travelPrice);
            }
            visited[src] = true;
            List<Integer> g = graph.get(src);
            for (Integer node : g) {
                String key = src + ":" + node;
                travelPrice += priceGraph.getOrDefault(key, 0);
                price = searchCheapestPrice(graph, priceGraph, visited, node, dest, k, price, ++travel, travelPrice);
                travelPrice -= priceGraph.getOrDefault(key, 0);
                --travel;
//                visited[src] = false;
            }
        }
        return price;
    }
}
