package com.example.datastructure.leetcode.problem.linkedlist;

public class ReverseLinkedList {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode start = null;
        while (temp != null) {
            start = new ListNode(temp.val, start);
            temp = temp.next;
        }
        return start;
    }


    static class ListNode {
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
