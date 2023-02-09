package com.example.datastructure.algoexpert.problem.binary.tree;

public class MaxPathSum {

    public static int maxPathSum(BinaryTree tree) {
        int[] path = new int[1];
        path[0] = Integer.MIN_VALUE;
        maxPath(tree, path);
        return path[0];
    }

    static int maxPath(BinaryTree tree, int[] path) {
        if (tree == null)
            return 0;
        int left = 0;
        int right = 0;
        if (tree.left != null) {
            left = maxPath(tree.left, path);
        }
        if (tree.right != null) {
            right = maxPath(tree.right, path);
        }
        int max = Math.max(left, right);
        int m = Math.max(left + tree.value + right, path[0]);
        m = Math.max(m, left + tree.value);
        m = Math.max(m, right + tree.value);
        path[0] = m;
        return max + tree.value;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        subarraySort(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19});
    }


    public static int[] subarraySort(int[] arr) {
        int i = 1;
        int j = arr.length - 2;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIndex = i;
        int maxIndex = j;
        while (i <= j) {
            if (arr[i - 1] < arr[i]) {
                i++;
                if (max < arr[i]) {
                    maxIndex = i;
                }
                max = Math.max(max, arr[i]);
            } else {
                minIndex = i;
                while (i <= j) {
                    if (min > arr[i]) {
                        minIndex = i;
                        min = arr[i];
                    }
                    if (i <= j && max < arr[i]) {
                        maxIndex = i;
                        max = Math.max(max, arr[i]);
                    }
                    i++;
                }
                if (min > arr[j]) {
                    minIndex = arr.length - 1;
                }
            }
            if (arr[j + 1] > arr[j]) {
                j--;
            }
        }
        System.out.println(minIndex + " " + maxIndex);

        return arr;
    }
}