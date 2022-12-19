package com.example.datastructure.linked.list;

import com.example.datastructure.random.GenerateRandom;

import java.util.ArrayList;
import java.util.List;

public class SinglyLinkedList<T> {

    private int size;
    private Node<T> head;
    private Node<T> recursive;

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
//        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 20; i++) {
            list.push(GenerateRandom.random(0, 1000));
        }
//        list.sort(Integer::compareTo);
        System.out.println(list.sort());
        long end = System.currentTimeMillis();
        System.out.println("Total Nano Time " + (end - l));
//
//        List<Integer> reverse = list.tailRecursive();
//        System.out.println(reverse);


    }

    public void push(T e) {
        Node<T> node = new Node<>(e, null);
        node.next = head;
        head = node;
    }

    public List<T> tailRecursive() {
        Node<T> n = this.head;
        Node<T> tNode = reverseUtils(n, null);
        List<T> ts = new ArrayList<>();
        returnReverse(ts, tNode);
        return ts;
    }

    public List<T> recursiveReverse() {
        List<T> reverse = new ArrayList<>();

        Node<T> current = head;
        Node<T> prev = rReverse(current);
        returnReverse(reverse, prev);
        return reverse;
    }

    private void returnReverse(List<T> reverse, Node<T> prev) {
        while (prev != null) {
            reverse.add(prev.element);
            prev = prev.next;
        }
    }

    public Node<T> rReverse(Node<T> head) {
        if (head == null || head.next == null)
            return head;
        Node<T> rest = rReverse(head.next);
        System.out.println("hello");
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public Node<T> reverseUtils(Node<T> curr, Node<T> prev) {
        if (curr == null)
            return curr;
        if (curr.next == null) {
            recursive = prev;
            curr.next = prev;
            return curr;
        }

        Node<T> next = curr.next;
        curr.next = prev;
        reverseUtils(next, curr);
        System.out.println("hello");
        return recursive;

    }

    public List<T> reverse() {
        List<T> reverse = new ArrayList<>();
        Node<T> current = head;
        Node<T> prev = null;
        Node<T> next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        returnReverse(reverse, prev);
        return reverse;
    }

    public void addFirst(T element) {
        Node<T> temp = this.head;
        head = new Node<>(element, temp);
        size++;
    }

    public void add(T element) {
        Node<T> temp = this.head;
        Node<T> tNode = new Node<>(element, null);
        if (temp == null) {
            head = tNode;
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = tNode;
        }
        size++;
    }

    public void addLast(T element) {
        add(element);
    }

    public void addAt(int idx, T element) {
        checkPosition(idx);
        if (size == idx) {
            addLast(element);
        } else if (idx == 0) {
            addFirst(element);
        } else {
            Node<T> node = node(idx - 1);
            Node<T> tNode = new Node<>(element, node.next);
            node.next = tNode;
            size++;
        }
    }

    private void checkPosition(int idx) {
        if (!(idx >= 0 && idx <= size))
            throw new IndexOutOfBoundsException(idx);
    }

    private Node<T> node(int idx) {

        Node<T> temp = this.head;
        for (int i = 0; temp != null; temp = temp.next, i++) {
            if (i == idx)
                break;
        }
        return temp;
    }

    public void display() {
        Node<T> temp = this.head;
        StringBuilder builder = new StringBuilder();
        builder.append("{ ");
        while (temp != null) {
            builder.append(temp.element);
            if (temp.next != null) {
                builder.append(", ");
            }
            temp = temp.next;
        }
        builder.append(" } ");
        System.out.println(builder);
    }

    public List<T> sort() {
        List<T> list = new ArrayList<>();
        Node<T> nNode = head;
        Node<T> sort = sort(nNode);
        returnReverse(list, sort);
        return list;
    }

    private Node<T> sort(Node<T> h) {
        if (h == null || h.next == null)
            return h;
        Node<T> middle = findMiddle(h);
        Node<T> next = middle.next;
        middle.next = null;
        Node<T> left = sort(h);
        Node<T> right = sort(next);
        return mergeSort(left, right);
    }

    private Node<T> mergeSort(Node<T> left, Node<T> right) {
        Node<T> result = null;
        if (left == null)
            return right;
        if (right == null)
            return left;
        int leftE = (int) left.element;
        int rightE = (int) right.element;
        if (leftE <= rightE) {
            result = left;
            result.next = mergeSort(left.next, right);
        } else {
            result = right;
            result.next = mergeSort(left, right.next);
        }
        return result;
    }

    private Node<T> findMiddle(Node<T> h) {
        if (h == null)
            return h;
        Node<T> middle = h;
        Node<T> iterator = h;
        while (iterator.next != null && iterator.next.next != null) {
            middle = middle.next;
            iterator = iterator.next.next;
        }
        return middle;
    }

    private class Node<T> {
        private final T element;
        private Node<T> next;

        Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }
    }

}