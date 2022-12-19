package com.example.datastructure.tree;

import com.example.datastructure.tree.print.TreePrinter;
import lombok.Getter;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Stack;

import static java.util.Objects.isNull;

public class AVLBalanceTree<T extends Comparable<T>> implements Iterable<T> {

    public Node<T> root;

    @Getter
    private int size;

    public boolean contains(T value) {
        return contains(root, value);
    }

    public int height() {
        return isNull(root)
                ? 0
                : root.height;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0
                ? Boolean.TRUE
                : Boolean.FALSE;
    }

    private boolean contains(Node<T> node, T value) {
        if (isNull(node))
            return false;
        int compare = value.compareTo(node.value);
        if (compare < 0)
            return contains(node.left, value);
        else if (compare > 0)
            return contains(node.right, value);
        else
            return true;
    }


    public boolean insert(T value) {
        if (isNull(value) || contains(value))
            return false;
        root = insert(root, value);
        size++;
        return true;
    }

    public boolean remove(T value) {
        if (isNull(value) || !contains(value))
            return false;
        root = remove(root, value);
        size--;
        return true;
    }

    private Node<T> remove(Node<T> node, T value) {
        if (isNull(node))
            return null;
        int compare = value.compareTo(node.value);
        if (compare < 0)
            node.left = remove(node.left, value);
        else if (compare > 0)
            node.right = remove(node.right, value);
        else {
            if (isNull(node.right))
                return node.left;
            else if (isNull(node.left))
                return node.right;
            else {
                T val;
                if (node.left.height > node.right.height) {
                    val = findMax(node.left);
                    node.left = remove(node.left, val);
                } else {
                    val = findMin(node.right);
                    node.right = remove(node.right, val);
                }
                node.value = val;
            }
        }
        updateHeightAndBalanceFactor(node);
        return balance(node);
    }

    private T findMax(Node<T> node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.value;
    }

    private T findMin(Node<T> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.value;
    }

    private Node<T> insert(Node<T> node, T value) {
        if (isNull(node))
            return new Node<>(value);
        int compare = value.compareTo(node.value);
        if (compare < 0) {
            node.left = insert(node.left, value);
        } else if (compare > 0) {
            node.right = insert(node.right, value);
        }
        updateHeightAndBalanceFactor(node);
        return balance(node);
    }

    private Node<T> balance(Node<T> node) {
        int balanceF = node.balanceFactor;
        if (balanceF > 1) {
            if (node.right.balanceFactor < 0)
                return rightLeftCase(node);
            return rightRightCase(node);
        } else if (balanceF < -1) {
            if (node.left.balanceFactor > 0)
                return leftRightCase(node);
            return leftLeftCase(node);
        }
        return node;
    }

    private Node<T> rightRightCase(Node<T> node) {
        return leftRotation(node);
    }

    private Node<T> leftLeftCase(Node<T> node) {
        return rightRotation(node);
    }

    private Node<T> rightLeftCase(Node<T> node) {
        node.right = rightRotation(node.right);
        return rightRightCase(node);
    }

    private Node<T> leftRightCase(Node<T> node) {
        node.left = leftRotation(node.left);
        return leftLeftCase(node);
    }

    private Node<T> rightRotation(Node<T> node) {
        Node<T> parent = node.left;
        node.left = parent.right;
        parent.right = node;
        updateHeightAndBalanceFactor(node);
        updateHeightAndBalanceFactor(parent);
        return parent;
    }

    private Node<T> leftRotation(Node<T> node) {
        Node<T> parent = node.right;
        node.right = parent.left;
        parent.left = node;
        updateHeightAndBalanceFactor(node);
        updateHeightAndBalanceFactor(parent);
        return parent;
    }

    private void updateHeightAndBalanceFactor(Node<T> node) {
        int leftHeight = isNull(node.left) ? -1 : node.left.height;
        int rightHeight = isNull(node.right) ? -1 : node.right.height;
        node.height = Math.max(leftHeight, rightHeight) + 1;
        node.balanceFactor = rightHeight - leftHeight;
    }

    public boolean validateBinarySearchTree(Node<T> node) {
        if (isNull(node))
            return true;
        T value = node.value;
        boolean isValid = true;
        if (!isNull(node.left())) {
            int compare = value.compareTo(node.left.value);
            isValid = compare > 0;
        }
        if (!isNull(node.right)) {
            int compare = value.compareTo(node.right.value);
            isValid = isValid && compare < 0;
        }
        return isValid && validateBinarySearchTree(node.left) && validateBinarySearchTree(node.right);
    }

    public boolean validateBalanceFactorValues(Node<T> root) {
        if (root == null)
            return true;
        if (root.balanceFactor > 1 || root.balanceFactor < -1)
            return false;
        return validateBinarySearchTree(root.left) && validateBinarySearchTree(root.right);
    }

    @Override
    public String toString() {
        return TreePrinter.getDisplayTree(root);
    }

    // Incomplete
    @Override
    public Iterator<T> iterator() {
        int expectedCount = size;
        final Stack<Node<T>> stack = new Stack<>();
        stack.push(root);
        return new Iterator<T>() {
            Node<T> trav = root;

            @Override
            public boolean hasNext() {
                if (expectedCount != size) throw new ConcurrentModificationException();
                return !stack.isEmpty() && root != null;
            }

            @Override
            public T next() {
                if (expectedCount != size) throw new ConcurrentModificationException();
                while (trav != null && trav.left != null) {
                    stack.push(trav.left);
                    trav = trav.left;
                }

                Node<T> n = stack.pop();
                if (trav != null && trav.right != null) {
                    stack.push(trav.right);
                    trav = trav.right;
                }
                return n.value;
            }
        };
    }

    public class Node<T> implements TreePrinter.PrintableTree {

        @Getter
        private int height;
        @Getter
        private int balanceFactor;
        @Getter
        private T value;
        private Node<T> left, right;

        public Node(T value) {
            this.value = value;
        }

        public Node<T> left() {
            return left;
        }

        public Node<T> right() {
            return right;
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
