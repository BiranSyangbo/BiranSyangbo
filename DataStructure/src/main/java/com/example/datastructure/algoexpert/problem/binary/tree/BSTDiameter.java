package com.example.datastructure.algoexpert.problem.binary.tree;

public class BSTDiameter {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public int binaryTreeDiameter(BinaryTree tree) {
        int[] ints = new int[1];
        helper(tree, ints);
        return ints[0];
    }

    public int helper(BinaryTree tree, int[] max) {
        if (tree == null)
            return 0;
        int leftPath = 0;
        int rightPath = 0;
        if (tree.left != null)
            leftPath = helper(tree.left, max) + 1;
        if (tree.right != null)
            rightPath = helper(tree.right, max) + 1;
        max[0] = Math.max(max[0], leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }
}
