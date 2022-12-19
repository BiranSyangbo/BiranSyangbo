package com.example.datastructure.leetcode.problem.linkedlist;

public class MiddleOfLinkedList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        middleNode(listNode);
    }


    public static ListNode middleNode(ListNode head) {
        ListNode temp = head;
        ListNode temp1 = temp;
        while (temp1 != null && temp1.next != null) {
            temp = temp.next;
            temp1 = temp1.next.next;
        }
        return temp;
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
