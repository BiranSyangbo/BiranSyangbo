package com.example.datastructure.algoexpert.problem.binary.tree;

import java.util.*;

public class FindKDistanceNode {

    public static void main(String[] args) {
        var root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.left.left = new BinaryTree(3);
        root.left.left.left = new BinaryTree(4);
        root.left.left.left.left = new BinaryTree(5);
        int target = 2;
        int k = 3;
        new FindKDistanceNode().findNodesDistanceKBST(root, target, k);
        var expected = new ArrayList<Integer>(Arrays.asList(2, 7, 8));
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }


    public ArrayList<Integer> findNodesDistanceKBST(BinaryTree tree, int target, int k) {
        var graph = findParent(tree, null, new HashMap<>());
        var targetNode = findNode(tree, target, graph.get(target));
        var queue = new ArrayDeque<Object[]>();
        queue.offer(new Object[]{targetNode, 0});
        var visited = new HashMap<BinaryTree, Integer>();
        var list = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            var obj = queue.poll();
            var tNode = (BinaryTree) obj[0];
            int distance = (int) obj[1];
            visited.put(tNode, distance);
            if (distance > k)
                continue;
            if (distance == k) {
                list.add(tNode.value);
                continue;
            }
            var treeList = Arrays.asList(graph.get(tNode.value), tNode.left, tNode.right);
            for (BinaryTree t : treeList) {
                if (t != null && !visited.containsKey(t)) {
                    queue.offer(new Object[]{t, distance + 1});
                }
            }
        }
        System.out.println(list);
        return list;
    }

    public BinaryTree findNode(BinaryTree tree, int target, BinaryTree parentNode) {
        if (tree.value == target)
            return tree;
        if (parentNode.left != null && parentNode.left.value == target)
            return parentNode.left;
        return parentNode.right;
    }

    public Map<Integer, BinaryTree> findParent(BinaryTree tree, BinaryTree parent, Map<Integer, BinaryTree> graph) {
        if (tree != null) {
            graph.put(tree.value, parent);
            findParent(tree.left, tree, graph);
            findParent(tree.right, tree, graph);
        }
        return graph;
    }

    public ArrayList<Integer> findNodesDistanceKDST(BinaryTree tree, int target, int k) {
        Map<Integer, List<Integer>> graph = prepareGraph(tree, null, new HashMap<>());
        System.out.println(graph);
        return distance(graph, target, k, 0, new ArrayList<Integer>(), new HashMap<Integer, Integer>());
    }

    public ArrayList<Integer> distance(Map<Integer, List<Integer>> graph, int node, int distance, int traveld, ArrayList<Integer> traveledDistance, Map<Integer, Integer> visited) {
        visited.put(node, node);
        List<Integer> edges = graph.getOrDefault(node, new ArrayList<>());
        if (traveld == distance) {
            traveledDistance.add(node);
            return traveledDistance;
        }
        for (int edge : edges) {
            if (!visited.containsKey(edge)) {
                distance(graph, edge, distance, traveld + 1, traveledDistance, visited);
            }
        }
        return traveledDistance;
    }

    public Map<Integer, List<Integer>> prepareGraph(BinaryTree tree, BinaryTree parent, Map<Integer, List<Integer>> graph) {
        if (tree == null)
            return graph;
        List<Integer> edge = new ArrayList<>();
        if (parent != null) {
            edge.add(parent.value);
        }
        if (tree.left != null) {
            edge.add(tree.left.value);
        }
        if (tree.right != null) {
            edge.add(tree.right.value);
        }
        graph.put(tree.value, edge);
        prepareGraph(tree.left, tree, graph);
        prepareGraph(tree.right, tree, graph);
        return graph;
    }

}
