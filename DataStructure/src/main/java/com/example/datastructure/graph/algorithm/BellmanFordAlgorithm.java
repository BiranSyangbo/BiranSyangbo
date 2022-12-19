package com.example.datastructure.graph.algorithm;

import com.example.datastructure.graph.data.WeightGraph;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BellmanFordAlgorithm {

    public static void main(String[] args) {
        Integer[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        WeightGraph<Integer> graph = new WeightGraph<>(arr.length, arr);
//        graph.addEdge(0, 1, -1);
//        graph.addEdge(0, 2, 4);
//        graph.addEdge(1, 2, 3);
//        graph.addEdge(1, 4, 2);
//        graph.addEdge(1, 3, 2);
//        graph.addEdge(3, 1, 1);
//        graph.addEdge(3, 2, 5);
//        graph.addEdge(4, 3, -3);

        graph.addEdge(0, 1, 5);
        graph.addEdge(1, 6, 60);
        graph.addEdge(1, 2, 20);
        graph.addEdge(1, 5, 30);
        graph.addEdge(2, 3, 10);
        graph.addEdge(2, 4, 75);
        graph.addEdge(3, 2, -15);
        graph.addEdge(4, 9, 100);
        graph.addEdge(5, 4, 25);
        graph.addEdge(5, 6, 5);
        graph.addEdge(5, 8, 50);
        graph.addEdge(6, 7, -50);
        graph.addEdge(7, 8, -10);
        bellmanForm(graph.size(), graph.getGraph());
    }

    public static void bellmanForm(int v, Map<Integer, List<WeightGraph.Edge<Integer>>> graph) {
        Double[] distance = new Double[v];
        Arrays.fill(distance, Double.POSITIVE_INFINITY);
        distance[0] = 0.0;
        for (int i = 0; i < v - 1; i++) {
            for (Map.Entry<Integer, List<WeightGraph.Edge<Integer>>> entry : graph.entrySet()) {
                for (WeightGraph.Edge<Integer> edge : entry.getValue()) {
                    if (edge.getWeight() + distance[edge.from()] < distance[edge.to()]) {
                        distance[edge.to()] = edge.getWeight() + distance[edge.from()];
                    }
                }
            }
        }

        for (int i = 0; i < v - 1; i++) {
            for (Map.Entry<Integer, List<WeightGraph.Edge<Integer>>> entry : graph.entrySet()) {
                for (WeightGraph.Edge<Integer> edge : entry.getValue()) {
                    if (edge.getWeight() + distance[edge.from()] < distance[edge.to()]) {
                        distance[edge.to()] = Double.NEGATIVE_INFINITY;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(distance));

    }

}
