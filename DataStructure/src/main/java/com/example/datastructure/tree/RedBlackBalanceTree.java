package com.example.datastructure.tree;

import com.example.datastructure.tree.print.TreePrinter;
import lombok.Getter;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import static java.awt.Color.*;
import static java.util.Objects.isNull;

public class RedBlackBalanceTree<T extends Comparable<T>> implements Iterable<T> {

    @Getter
    private int size;

    @Getter
    private Node<T> root;

    public boolean insert(T value) {
        if (isNull(value) || contains(value))
            return false;
        Node<T> newNode = new Node<>(value);
        root = insert(root, newNode);
        recolorOrRotate(newNode);
        size++;
        return true;
    }

    private void recolorOrRotate(Node<T> node) {
        Node<T> parent = node.parent();
        if (!isNull(parent) && parent.colour == RED) {
            Node<T> grandpa = node.parent.parent;
            Node<T> uncle = node.parent.isLeftChild() ? grandpa.right : grandpa.left;
            if (!isNull(uncle) && uncle.isRed()) {
                recoloring(uncle, node);
            } else {
                if (node.parent.isLeftChild()) {
                    leftCase(node, grandpa);
                } else {
                    rightCase(node, grandpa);
                }
            }
        }
        root.setColour(BLACK);
    }

    private void rightCase(Node<T> node, Node<T> grandpa) {
        if (node.isLeftChild()) {
            node = node.parent;
            rightRotation(node);
        }
        node.parent.flipColor();
        grandpa.flipColor();
        leftRotation(grandpa);
//        if (!isNull(node.parent))
//            recolorOrRotate(node.isRightChild() ? node.parent : grandpa);
    }

    private void leftCase(Node<T> node, Node<T> grandpa) {
        if (node.isRightChild()) {
            node = node.parent;
            leftRotation(node);
        }
        node.parent.flipColor();
        grandpa.flipColor();
        rightRotation(grandpa);
//        if (!isNull(node.parent))
//            recolorOrRotate(node.isLeftChild() ? node.parent : grandpa);
    }

    private void leftRotation(Node<T> node) {
        Node<T> newNode = node.right;
        node.right = newNode.left;
        newNode.left = node;
        newNode.setParent(node.parent());
        updateChildOrParent(node, newNode);
        node.setParent(newNode);
    }

    private void updateChildOrParent(Node<T> node, Node<T> newNode) {
        if (isNull(node.parent)) {
            root = newNode;
        } else if (node.isLeftChild()) {
            node.parent().left = newNode;
        } else {
            node.parent().right = newNode;
        }
    }

    private void rightRotation(Node<T> node) {
        Node<T> newNode = node.left;
        node.left = newNode.right;
        newNode.right = node;
        newNode.setParent(node.parent());
        updateChildOrParent(node, newNode);
        node.setParent(newNode);
    }

    private void recoloring(Node<T> sibling, Node<T> node) {
        sibling.flipColor();
        node.parent().flipColor();
        node.parent.parent().flipColor();
        recolorOrRotate(node.parent.parent);
    }

    private Node<T> insert(Node<T> node, Node<T> newNode) {
        if (isNull(node))
            return newNode;
        int compare = newNode.value.compareTo(node.value);
        if (compare < 0) {
            node.left = insert(node.left, newNode);
            node.left.setParent(node);
        } else if (compare > 0) {
            node.right = insert(node.right, newNode);
            node.right.setParent(node);
        }
        return node;
    }

    public String toString() {
        return TreePrinter.getDisplayTree(root);
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T val) {
        return contains(root, val);
    }

    private boolean contains(Node<T> node, T val) {
        if (isNull(node) || isNull(val))
            return false;
        Node<T> n = node;
        while (n != null) {
            int compare = val.compareTo(n.value);
            if (compare < 0)
                n = n.left;
            else if (compare > 0)
                n = n.right;
            else
                return true;
        }
        return false;
    }

    public List<T> inOrderTraversal() {
        List<T> arr = new ArrayList<>();
        inorderTraversal(root, arr);
        return arr;
    }

    private void inorderTraversal(Node<T> tree, List<T> arr) {
        if (tree != null) {
            inorderTraversal(tree.left, arr);
            arr.add(tree.value);
            inorderTraversal(tree.right, arr);
        }
    }

    public class Node<T> implements TreePrinter.PrintableTree {

        @Getter
        private Color colour = RED;
        @Getter
        private T value;
        private Node<T> left, right, parent;

        public Node(T value) {
            this.value = value;
        }

        public Node<T> left() {
            return left;
        }

        public Node<T> right() {
            return right;
        }

        public Node<T> parent() {
            return parent;
        }

        public boolean isLeftChild() {
            return this == parent.left;
        }

        public boolean isRightChild() {
            return this == parent.right;
        }

        public boolean isRed() {
            return this.colour == RED;
        }

        public boolean isBlack() {
            return !isRed();
        }

        public void flipColor() {
            this.colour = (colour == RED) ? BLACK
                    : RED;
        }

        public void setColour(Color colour) {
            this.colour = colour;
        }

        public void setParent(Node<T> parent) {
            this.parent = parent;
        }

        @Override
        public TreePrinter.PrintableTree getLeft() {
            return left;
        }

        @Override
        public TreePrinter.PrintableTree getRight() {
            return right;
        }

        @Override
        public String getText() {
            return value.toString();
        }
    }
}
