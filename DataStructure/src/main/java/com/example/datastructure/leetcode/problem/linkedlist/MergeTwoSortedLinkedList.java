package com.example.datastructure.leetcode.problem.linkedlist;

// TAG:- Linked List, Recursion
public class MergeTwoSortedLinkedList<T> {

    private Node<T> head;

    public static void main(String[] args) {
        MergeTwoSortedLinkedList<Integer> firstList = new MergeTwoSortedLinkedList<>();
        MergeTwoSortedLinkedList<Integer> secondList = new MergeTwoSortedLinkedList<>();
        for (int i = 1; i <= 5; i++) {
            firstList.add(i);
            secondList.add(i * 2);
        }
        Node<Integer> integerNode = new MergeTwoSortedLinkedList<Integer>().mergeSortedList(firstList.head, secondList.head);
        new MergeTwoSortedLinkedList<Integer>().display(integerNode);

    }

    public void display(Node<T> head) {
        Node<T> temp = head;
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

    public Node<Integer> mergeSortedList(Node<Integer> firstList, Node<Integer> second) {
        if (firstList == null)
            return second;
        if (second == null)
            return firstList;
        if (firstList.element < second.element) {
            firstList.next = mergeSortedList(firstList.next, second);
            System.out.print("First Is => ");
            display((Node<T>) firstList);
            System.out.println();
            return firstList;
        }
        second.next = mergeSortedList(firstList, second.next);
        System.out.print("Second is = ");
        display((Node<T>) second);
        System.out.println();
        return second;
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
    }


    private static class Node<T> {
        private final T element;
        private Node<T> next;

        Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }
    }
}
