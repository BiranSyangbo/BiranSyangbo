package com.example.datastructure.leetcode.problem.linkedlist;

public class DeleteNthNodeFromEndLinkedList {
    public static void main(String[] args) {
//        ListNode lNode = new ListNode(2);
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode = removeNthFromEndLeetCode(node, 4);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public static ListNode removeNthFromEndLeetCode(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        start.next = head;
        for (int i = 0; i <=n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return start.next;

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null)
            return null;
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        temp = head;
        if (size == (size - n)) {
            head = head.next;
            return head;
        }
        if (size == n) {
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;

        } else {
            int count = 1;
            while (count != (size - n) && temp.next != null) {
                temp = temp.next;
                count++;
            }
            ListNode next = temp.next.next;
            temp.next = next;
        }
        return head;
    }

    final static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
