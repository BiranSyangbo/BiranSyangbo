package com.example.datastructure.tree;

import javax.print.DocFlavor;
import java.util.Objects;

public class BSTConstruction {
    public static void main(String[] args) {

//        root.left = new BST(5);
//        root.left.left = new BST(2);
//        root.left.left.left = new BST(1);
//        root.left.right = new BST(5);
//        root.right = new BST(15);
//        root.right.left = new BST(13);
//        root.right.left.right = new BST(14);
//        root.right.right = new BST(22);
//
//        root.insert(12);
//        System.out.println(root.right.left.left.value);
//        root.remove(10);
//        System.out.println(root.value);
    }

    public static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            BST root = this;
            BST tBst = new BST(value);
            while (true) {
                if (root.value > value) {
                    if (root.left == null) {
                        root.left = tBst;
                        break;
                    }
                    root = root.left;
                } else {
                    if (root.right == null) {
                        root.right = tBst;
                        break;
                    }
                    root = root.right;
                }
            }

            return this;
        }

        public boolean contains(int value) {
            BST root = this;
            while (root != null) {
                if (value < root.value) {
                    root = root.left;
                } else if (value > root.value)
                    root = root.right;
                else {
                    return true;
                }
            }
            return false;
        }

        // failed
        public BST remove(int value) {
            BST root = this;
            while (root != null) {
                if (root.value < value) {
                    root.right.remove(value);
                } else if (root.value > value) {
                    root.left.remove(value);
                } else {
                    if (root.right != null && root.left != null) {
                        int val = root.right.getMin();
                        root.right.remove(val);
                        root.value = value;

                    } else {
                        if (root.right == null && root.left == null)
                            return null;
                        if (root.left != null) {
                            root.value = root.left.value;
                            root.left = root.left.left;
                            if (root.left == null)
                                root.right = null;
                            else
                                root.right = root.left.right;
                            return root;
                        } else {
                            root.value = root.right.value;
                            root.right = root.right.right;
                            if (root.right == null)
                                root.left = null;
                            else
                                root.left = root.right.left;
                            return root;
                        }
                    }
                    return root;
                }
            }
            return this;
        }

        // Iterative
        public BST remove1(int value) {
            remove(value, this);
            return this;
        }

        public BST remove(int value, BST root) {
            if (root == null)
                return null;
            if (root.value < value && root.right != null) {
                root.right = remove(value, root.right);
            } else if (root.value > value && root.left != null) {
                root.left = remove(value, root.left);
            } else {

                if (root.left == null && root.right == null)
                    return null;

                if (root.left != null && root.right == null) {
                    root.value = root.left.value;
                    root.left = root.left.left;
                    root.right = root.left.right;
                }

                if (root.right != null && root.left == null) {
                    root.value = root.right.value;
                    root.right = root.right.right;
                    root.left = root.right.left;
                }
                if (root.left != null && root.right != null) {
                    int val = root.right.getMin();
                    root.right.remove(val);
                    root.value = val;
                }

            }
            return root;
        }

        private int getMin() {
            BST root = this;
            while (root.left != null) {
                root = root.left;
            }
            return root.value;
        }
    }
}
