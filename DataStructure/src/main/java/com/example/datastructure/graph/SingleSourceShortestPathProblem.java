package com.example.datastructure.graph;

import com.example.datastructure.graph.data.WeightGraph;

import java.util.*;

public class SingleSourceShortestPathProblem {

    public static void main(String[] args) {
        String[] vertex = {"A", "B", "C", "D", "E", "F", "G", "H"};
        WeightGraph<String> graph = new WeightGraph<>(vertex.length, vertex);
        graph.addEdge("A", "B", 3);
        graph.addEdge("A", "C", 6);
        graph.addEdge("B", "C", 4);
        graph.addEdge("B", "D", 4);
        graph.addEdge("B", "E", 11);
        graph.addEdge("C", "D", 8);
        graph.addEdge("C", "G", 11);
        graph.addEdge("D", "G", 2);
        graph.addEdge("D", "F", 5);
        graph.addEdge("D", "E", -4);
        graph.addEdge("E", "H", 9);
        graph.addEdge("F", "H", 1);
        graph.addEdge("G", "H", 2);
        new SingleSourceShortestPathProblem().sssp(graph, "A");
    }

    public void sssp(WeightGraph<String> graph, String start) {
        Stack<String> topoSort = topologicalSort(graph);

        Map<String, Integer> dist = new HashMap<>(graph.size());

        dist.put(start, 0);

        Map<String, List<WeightGraph.Edge<String>>> edge = graph.getGraph();

        for (int i = 0; i < graph.size(); i++) {
            String pop = topoSort.pop();
            for (WeightGraph.Edge<String> element : edge.get(pop)) {
                int newDist = dist.get(pop) + element.getWeight();
                dist.merge(element.to(), newDist, (a, b) -> Math.min(b, a));
            }
        }

        System.out.println(dist);


    }

    private Stack<String> topologicalSort(WeightGraph<String> graph) {
        Map<String, Boolean> visited = new HashMap<>();
        String[] vertex = graph.getVertex();
        for (int i = 0; i < graph.size(); i++) {
            visited.put(vertex[i], Boolean.FALSE);
        }

        Stack<String> topoSort = new Stack<>();
        for (int i = 0; i < graph.size(); i++) {
            dfs(vertex[i], visited, graph.getGraph(), topoSort);
        }
        return topoSort;
    }

    private void dfs(String vertex, Map<String, Boolean> visited, Map<String, List<WeightGraph.Edge<String>>> graph, Stack<String> topoSort) {
        if (!visited.get(vertex)) {
            visited.put(vertex, Boolean.TRUE);
            for (WeightGraph.Edge<String> edge : graph.get(vertex)) {
                if (!visited.get(edge.to())) {
                    dfs(edge.to(), visited, graph, topoSort);
                }
            }
            topoSort.push(vertex);
        }
    }


}
