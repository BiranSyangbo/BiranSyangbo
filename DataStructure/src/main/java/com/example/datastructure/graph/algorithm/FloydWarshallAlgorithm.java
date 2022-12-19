package com.example.datastructure.graph.algorithm;

import com.example.datastructure.graph.data.WeightGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.POSITIVE_INFINITY;

public class FloydWarshallAlgorithm {
    double[][] dp;
    int[][] next;

    public static void main(String[] args) {
//        Integer[] vertices = {0, 1, 2, 3};
//        WeightGraph<Integer> graph = new WeightGraph<>(vertices.length, vertices);
//        graph.addEdge(0, 3, 5);
//        graph.addEdge(0, 1, 3);
//        graph.addEdge(1, 0, 2);
//        graph.addEdge(1, 3, 4);
//        graph.addEdge(2, 1, 1);
//        graph.addEdge(3, 2, 2);
//        int size = graph.size();
        int size = 7;
        FloydWarshallAlgorithm floydWarshallAlgorithm = new FloydWarshallAlgorithm(size);
//        double[][] matrixAdjacentList = floydWarshallAlgorithm.conversionToMatrixAdjacentList(graph.getGraph());

        double[][] m = createGraph(7);
        m[0][1] = 2;
        m[0][2] = 5;
        m[0][6] = 10;
        m[1][2] = 2;
        m[1][4] = 11;
        m[2][6] = 2;
        m[6][5] = 11;
        m[4][5] = 1;
        m[5][4] = -2;
        floydWarshallAlgorithm
                .floydWarshall(m);


        for (int i = 1; i <= size; i++)
            for (int j = 1; j <= size; j++)
                System.out.printf("This shortest path from node %d to node %d is %.3f\n", i, j, floydWarshallAlgorithm.dp[i - 1][j - 1]);


        floydWarshallAlgorithm.printPathBetweenVertices(size);
    }

    public static double[][] createGraph(int n) {
        double[][] matrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(matrix[i], POSITIVE_INFINITY);
            matrix[i][i] = 0;
        }
        return matrix;
    }


    FloydWarshallAlgorithm(int size) {
        dp = new double[size][size];
        next = new int[size][size];
    }


    private void floydWarshall(double[][] graph) {
        setup(graph);
        int size = graph.length;
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (dp[i][j] > dp[i][k] + dp[k][j]) {
                        dp[i][j] = dp[i][k] + dp[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (dp[i][j] > dp[i][k] + dp[k][j]) {
                        dp[i][j] = NEGATIVE_INFINITY;
                        next[i][j] = -1;
                    }
                }
            }
        }
    }

    private List<Integer> reconstructShortestPath(int start, int end) {
        List<Integer> path = new ArrayList<>();

        if (dp[start][end] == NEGATIVE_INFINITY) return path;

        int at = start;

        for (; at != end; at = next[at][end]) {
            if (at == -1) return null;
            path.add(at);
        }

        if (next[at][end] == -1)
            return null;
        path.add(end);
        return path;
    }


    private void setup(double[][] graph) {
        int size = graph.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                dp[i][j] = graph[i][j];
                if (graph[i][j] != Double.POSITIVE_INFINITY)
                    next[i][j] = j;
            }
        }
    }


    private double[][] conversionToMatrixAdjacentList(Map<Integer, List<WeightGraph.Edge<Integer>>> graph) {
        int size = graph.size();
        double[][] matrixAdjGraph = new double[size][size];

        for (int i = 0; i < size; i++) {
            Arrays.fill(matrixAdjGraph[i], Double.POSITIVE_INFINITY);
            matrixAdjGraph[i][i] = 0;
        }

        graph.forEach((_key, _value) -> {
            for (WeightGraph.Edge<Integer> _edge : _value) {
                matrixAdjGraph[_edge.from()][_edge.to()] = _edge.getWeight();
            }
        });

        return matrixAdjGraph;
    }

    public void printPathBetweenVertices(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                List<Integer> path = reconstructShortestPath(i - 1, j - 1);
                String str;
                if (path == null) {
                    str = "HAS AN ∞ NUMBER OF SOLUTIONS! (negative cycle case)";
                } else if (path.size() == 0) {
                    str = String.format("DOES NOT EXIST (node %d doesn't reach node %d)", i, j);
                } else {
                    str = path.stream().map(Object::toString).collect(Collectors.joining(" -> "));
                    str = "[ " + str + " ]";

                }

                System.out.printf("The shortest path from node %d to node %d %s\n", i, j, str);

            }
        }
    }
}
