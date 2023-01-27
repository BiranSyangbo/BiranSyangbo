package com.example.datastructure.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTConstructionTest {


    @Test
    void testCase() {
        var root = new BSTConstruction.BST(12);
        root.remove(12);
        assertNotEquals(12, root.value);
    }
    @Test
    void testCase1() {
        var root = new BSTConstruction.BST(1);
        root.left = new BSTConstruction.BST(-2);
        root.left.left = new BSTConstruction.BST(-23);
        root.left.left.left = new BSTConstruction.BST(-44);
        root.remove(1);
        assertEquals(-2, root.value);
//        var root = new BST(10);
    }

    @Test
    void testCase2() {
        var root = new BSTConstruction.BST(10);
        root.left = new BSTConstruction.BST(5);
        root.left.left = new BSTConstruction.BST(2);
        root.left.left.left = new BSTConstruction.BST(1);
        root.left.right = new BSTConstruction.BST(5);
        root.right = new BSTConstruction.BST(15);
        root.right.left = new BSTConstruction.BST(13);
        root.right.left.right = new BSTConstruction.BST(14);
        root.right.right = new BSTConstruction.BST(22);
        root.insert(12);
        assertEquals(12, root.right.left.left.value);
        root.remove(10);
        assertFalse(root.contains(10));
        assertEquals(12, root.value);
        assertTrue(root.contains(15));
    }

    @Test
    void testCase3() {
        var root = new BSTConstruction.BST(10);
        root.insert(5);
        root.remove(10);
        root.contains(15);

    }
}