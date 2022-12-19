package com.example.datastructure.graph.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightGraph<T> {

    Map<T, List<Edge<T>>> edge;

    private final T[] vertex;

    private final int size;

    public static class Edge<T> {
        T from;
        T to;
        int weight;

        public Edge(T from, T to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public T from() {
            return from;
        }

        public T to() {
            return to;
        }

        public int getWeight() {
            return weight;
        }
    }

    public WeightGraph(int size, T[] vertex) {
        this.vertex = vertex;
        this.size = size;
        edge = new HashMap<>(size);
        for (int i = 0; i < size; i++) {
            edge.put(vertex[i], new ArrayList<>());
        }
    }

    public void addEdge(T from, T to, int weight) {
        edge.get(from).add(new Edge<>(from, to, weight));
    }

    public Map<T, List<Edge<T>>> getGraph() {
        return edge;
    }

    public int size() {
        return size;
    }

    public T[] getVertex() {
        return vertex;
    }
}

