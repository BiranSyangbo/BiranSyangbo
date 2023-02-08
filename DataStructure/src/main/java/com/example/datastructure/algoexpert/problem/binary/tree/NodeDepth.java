package com.example.datastructure.algoexpert.problem.binary.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class NodeDepth {

    public static void main(String[] args) {
        var root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.left.left = new BinaryTree(4);
        root.left.left.left = new BinaryTree(8);
        root.left.left.right = new BinaryTree(9);
        root.left.right = new BinaryTree(5);
        root.right = new BinaryTree(3);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);
        int actual = nodeDepths(root);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(null);
    }

    public static int nodeDepths(BinaryTree root) {
        int depth = depthHelper(root, 0);
        System.out.println(depth);
        return depth;
    }

    static int depthHelper(BinaryTree tree, int move) {
        if (tree.left == null && tree.right == null)
            return move;
        int val = 0;
        if (tree.left != null)
            val += depthHelper(tree.left, move + 1);
        if (tree.right != null)
            val += depthHelper(tree.right, move + 1);
        return move + val;

    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
