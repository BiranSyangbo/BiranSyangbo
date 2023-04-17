package com.example.datastructure.algoexpert.problem.binary.tree;

import org.junit.jupiter.api.Test;

import java.util.*;

import static com.example.datastructure.algoexpert.problem.binary.tree.FlatternBinaryTree.*;
import static org.junit.jupiter.api.Assertions.*;

class FlatternBinaryTreeTest {

    @Test
    void testCase1() {
        FlatternBinaryTree.BinaryTree root = new FlatternBinaryTree.BinaryTree(1);
        insert(root, new int[]{2, 3, 4, 5, 6});
        root.left.right.left = new FlatternBinaryTree.BinaryTree(7);
        root.left.right.right = new FlatternBinaryTree.BinaryTree(8);
        final FlatternBinaryTree.BinaryTree binaryTree = flattenBinaryTreeThirdWay(root);

        List<Integer> leftToRightToLeft = leftToRightToLeft(binaryTree);
        List<Integer> expected =
                new ArrayList<>(Arrays.asList(4, 2, 7, 5, 8, 1, 6, 3, 3, 6, 1, 8, 5, 7, 2, 4));
        assertArrayEquals(expected.toArray(), leftToRightToLeft.toArray());
    }

    @Test
    void testCase2() {
        FlatternBinaryTree.BinaryTree root = new FlatternBinaryTree.BinaryTree(1);

        root.left = newNode(2);
        root.right = newNode(3);

        root.left.left = newNode(4);
        root.left.right = newNode(5);
        root.right.left = newNode(6);
        root.right.right = newNode(7);

        root.left.left.left = newNode(8);
        root.left.left.right = newNode(9);
        root.left.right.left = newNode(10);
        root.left.right.right = newNode(11);
        root.right.left.left = newNode(12);
        root.right.left.right = newNode(13);
        root.right.right.left = newNode(14);
        root.right.right.right = newNode(15);

        root.left.left.left.left = newNode(16);
        root.left.left.left.right = newNode(17);
        root.left.left.right.left = newNode(18);
        root.left.left.right.right = newNode(19);
        root.left.right.left.left = newNode(20);
        root.left.right.left.right = newNode(21);
        root.left.right.right.left = newNode(22);
        root.left.right.right.right = newNode(23);
        root.right.left.left.left = newNode(24);
        root.right.left.left.right = newNode(25);
        root.right.left.right.left = newNode(26);
        root.right.left.right.right = newNode(27);
        root.right.right.left.left = newNode(28);
        root.right.right.left.right = newNode(29);
        root.right.right.right.left = newNode(30);
        root.right.right.right.right = newNode(31);
        flattenBinaryTreeFirstWay(root);
    }

    private FlatternBinaryTree.BinaryTree newNode(int i) {
        return new FlatternBinaryTree.BinaryTree(i);
    }


    public List<Integer> leftToRightToLeft(FlatternBinaryTree.BinaryTree leftMost) {
        List<Integer> nodes = new ArrayList<Integer>();
        FlatternBinaryTree.BinaryTree current = leftMost;
        while (current.right != null) {
            nodes.add(current.value);
            current = current.right;
        }
        nodes.add(current.value);
        while (current != null) {
            nodes.add(current.value);
            current = current.left;
        }
        return nodes;
    }


}