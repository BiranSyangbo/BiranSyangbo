package com.example.datastructure.algoexpert.problem.binary.tree;

import java.util.*;

public class FlatternBinaryTree {
    BinaryTree tree = null;

    public static BinaryTree flattenBinaryTreeFirstWay(BinaryTree root) {
        List<Integer> ans = new ArrayList<>();
        visitIOT(root, ans);
        BinaryTree main = new BinaryTree(ans.get(0));
        BinaryTree temp = main;

        System.out.println(ans);

        for (int i = 1; i < ans.size(); i++) {
            BinaryTree t = new BinaryTree(ans.get(i));
            t.left = temp;
            temp.right = t;
            temp = temp.right;
        }
        return root;
    }

    public static BinaryTree flattenBinaryTreeSecond(BinaryTree root) {
        Stack<BinaryTree> stack = new Stack<>();
        stack.push(root);
        Map<BinaryTree, Boolean> visit = new HashMap<>();
        FlatternBinaryTree p = new FlatternBinaryTree();
        while (!stack.isEmpty()) {
            BinaryTree temp = stack.peek();
            if (temp.left != null && !visit.getOrDefault(temp.left, false)) {
                stack.push(temp.left);
                continue;
            }
            p.callback(temp);
            stack.pop();
            visit.put(temp, true);
            if (temp.right != null) {
                stack.push(temp.right);
            }
        }
        return p.tree;
    }

    public static BinaryTree flattenBinaryTreeThirdWay(BinaryTree root) {
        return thirdWayHelper(root)[0];
    }

    static BinaryTree[] thirdWayHelper(BinaryTree tree) {
        BinaryTree leftNode = null, rightNode = null;
        if (tree.left == null) {
            leftNode = tree;
        } else {
            final BinaryTree[] binaryTrees = thirdWayHelper(tree.left);
            joinTwoTreeHelper(binaryTrees[1], tree);
            leftNode = binaryTrees[0];
        }

        if (tree.right == null) {
            rightNode = tree;
        } else {
            final BinaryTree[] binaryTrees = thirdWayHelper(tree.right);
            joinTwoTreeHelper(tree, binaryTrees[0]);
            rightNode = binaryTrees[1];
        }
        return new BinaryTree[]{leftNode, rightNode};
    }

    static void joinTwoTreeHelper(BinaryTree leftNode, BinaryTree rightNode) {
        leftNode.right = rightNode;
        rightNode.left = leftNode;
    }

    void callback(BinaryTree t) {
        System.out.println(t.value);
        BinaryTree temp = this.tree;
        BinaryTree newTree = new BinaryTree(t.value);
        if (this.tree == null) {
            this.tree = newTree;
            return;
        }
        while (temp != null && temp.right != null) {
            temp = temp.right;
        }
        newTree.left = temp;
        temp.right = newTree;
    }

    // This is the class of the input root. Do not edit it.
    static class BinaryTree {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }


    public static List<Integer> visitIOT(BinaryTree root, List<Integer> ans) {
        if (root != null) {
            visitIOT(root.left, ans);
            ans.add(root.value);
            visitIOT(root.right, ans);
        }
        return ans;

    }


    public static void insert(BinaryTree root, int[] values) {
        insert(root, values, 0);
    }

    public static void insert(BinaryTree root, int[] values, int i) {
        if (i >= values.length) {
            return;
        }
        Deque<BinaryTree> queue = new ArrayDeque<>();
        queue.addLast(root);
        while (queue.size() > 0) {
            BinaryTree current = queue.pollFirst();
            if (current.left == null) {
                current.left = new BinaryTree(values[i]);
                break;
            }
            queue.addLast(current.left);
            if (current.right == null) {
                current.right = new BinaryTree(values[i]);
                break;
            }
            queue.addLast(current.right);
        }
        insert(root, values, i + 1);
    }
}