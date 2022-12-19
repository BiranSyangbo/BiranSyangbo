package com.example.datastructure.linked.list;

import com.example.datastructure.random.GenerateRandom;

public class SortingLinkedList {

    private Node head;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int size = 10000;
        SortingLinkedList list = new SortingLinkedList();
        for (int i = 0; i < size; i++) {
            list.push(GenerateRandom.random(0, 1000));
        }
        list.sort();
        long end = System.currentTimeMillis();
        System.out.println("Total time  " + (end - start));
    }

    public void push(int element) {
        Node tNode = new Node(null, element);
        tNode.next = head;
        head = tNode;
    }

    public Node sort() {
        Node nHead = this.head;
        return sort(nHead);
    }

    public Node sort(Node h) {
        if (h == null || h.next == null) {
            return h;
        }

        Node mid = findMid(h);
        Node next = mid.next;
        mid.next = null;
        Node left = sort(h);
        Node right = sort(next);
        return mergeSort(left, right);

    }

    private Node mergeSort(Node left, Node right) {
        Node result;
        if (left == null)
            return right;
        if (right == null)
            return left;

        if (left.element < right.element) {
            result = left;
            result.next = mergeSort(left.next, right);
        } else {
            result = right;
            result.next = mergeSort(left, right.next);
        }
        return result;
    }

    private Node findMid(Node h) {
        if (h == null)
            return h;
        Node middle = h, iterator = h;

        while (iterator.next != null && iterator.next.next != null) {
            middle = middle.next;
            iterator = iterator.next.next;
        }
        return middle;
    }


    private class Node {
        Node next;
        Integer element;

        public Node(Node next, Integer element) {
            this.next = next;
            this.element = element;
        }
    }

}
