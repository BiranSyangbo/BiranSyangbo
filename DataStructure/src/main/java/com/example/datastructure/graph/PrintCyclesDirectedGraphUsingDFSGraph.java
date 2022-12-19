package com.example.datastructure.graph;

import java.util.ArrayList;
import java.util.Stack;

public class PrintCyclesDirectedGraphUsingDFSGraph {

    public static void main(String[] args) {
        int size = 8;
        Graph graph = new Graph(size);
        graph.addEdge(0, 1);
        graph.addEdge(1, 4);
        graph.addEdge(4, 0);
        graph.addEdge(4, 3);
        graph.addEdge(3, 1);
        graph.addEdge(3,4);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        graph.addEdge(7, 5);

        findCycles(graph.getGraphs(), size);
    }

    private static void findCycles(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                Stack<Integer> stack = new Stack<>();
                visited[i] = true;
                stack.push(i);
                processDFSTree(adj, stack, visited);
            }
        }
    }

    private static void processDFSTree(ArrayList<ArrayList<Integer>> ajd, Stack<Integer> stack, boolean[] visited) {
        ArrayList<Integer> adjecent = ajd.get(stack.peek());
        for (Integer v : adjecent) {
            if (visited[v] && stack.contains(v)) {
                printCycle(stack, v);
            } else {
                stack.push(v);
                visited[v] = true;
                processDFSTree(ajd, stack, visited);
            }
        }
        visited[stack.peek()] = true;
        stack.pop();
    }

    private static void printCycle(Stack<Integer> stack, int v) {
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(stack.pop());
        while (stack1.peek() != v) {
            stack1.push(stack.pop());
        }
        while (!stack1.isEmpty()) {
            int i = stack1.pop();
            System.out.print(i + " ");
            stack.push(i);
        }
        System.out.println();
    }

}
