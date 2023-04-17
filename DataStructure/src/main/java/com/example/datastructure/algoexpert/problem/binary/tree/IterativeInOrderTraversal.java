package com.example.datastructure.algoexpert.problem.binary.tree;

import java.awt.image.VolatileImage;
import java.util.function.Function;
import java.util.*;


public class IterativeInOrderTraversal {
    public List<Integer> testArray = new ArrayList<Integer>();

    public static void main(String[] args) {
        var root = new BinaryTree(1);
        root.left = new BinaryTree(2, root);
        root.left.left = new BinaryTree(4, root.left);
        root.left.left.right = new BinaryTree(9, root.left.left);
        root.right = new BinaryTree(3, root);
        root.right.left = new BinaryTree(6, root.right);
        root.right.right = new BinaryTree(7, root.right);
        var itT = new IterativeInOrderTraversal();
        itT.testArray.clear();
        it(root, itT::testCallback);
        System.out.println(itT.testArray);
        List<Integer> expected = Arrays.asList(4, 9, 2, 1, 6, 3, 7);
    }

    public Void testCallback(BinaryTree tree) {
        if (tree == null) {
            return null;
        }
        testArray.add(tree.value);
        return null;
    }

    public static void it(BinaryTree tree, Function<BinaryTree, Void> callback) {
        BinaryTree currentNode = tree;
        BinaryTree previousNode = null;
        while (currentNode != null) {
            BinaryTree nextNode;
            if (previousNode == null || currentNode.parent == previousNode) {
                if (currentNode.left != null) {
                    nextNode = currentNode.left;
                } else {
                    callback.apply(currentNode);
                    nextNode = currentNode.right != null ? currentNode.right : currentNode.parent;
                }

            } else if (currentNode.left == previousNode) {
                callback.apply(currentNode);
                nextNode = currentNode.right != null ? currentNode.right : currentNode.parent;
            } else {
                nextNode = currentNode.parent;
            }
            previousNode = currentNode;
            currentNode = nextNode;
        }
    }

    public static void iterativeInOrderTraversal(
            BinaryTree tree, Function<BinaryTree, Void> callback) {
        Stack<BinaryTree> iot = new Stack<>();
        BinaryTree temp = tree;
        iot.push(temp);
        Map<BinaryTree, Boolean> traveld = new HashMap<>();
        while (!iot.isEmpty()) {
            BinaryTree peek = iot.peek();
            if (peek.left != null && traveld.getOrDefault(peek.left, true)) {
                iot.push(peek.left);
                continue;
            }

            callback.apply(peek);
            BinaryTree t = iot.pop();
            traveld.put(t, false);
            if (peek.right != null) {
                iot.push(peek.right);
            }
        }
    }

    private static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;
        public BinaryTree parent;

        public BinaryTree(int value) {
            this.value = value;
        }

        public BinaryTree(int value, BinaryTree parent) {
            this.value = value;
            this.parent = parent;
        }
    }
}
