package com.example.datastructure.leetcode.problem.linkedlist;

import java.util.HashMap;

public class SwapNodeInPairs {
    public static void main(String[] args) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        ListNode listNode1 = new SwapNodeInPairs().swapPairs(listNode);
        while (listNode1 != null) {
            System.out.print(listNode1.val + " ");
            listNode1 = listNode1.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode currNode = head; // 1 ->
        while (currNode != null && currNode.next != null) {
            ListNode temp = currNode.next.next; // 3 ->
            currNode.next.next = currNode; // 1 -> 2 -> 1 -> 2 -> 3;
            currNode = currNode.next; //
        }
        return head;
    }
//
//    public ListNode swapPairs(ListNode head) {
//        ListNode temp = head;
//        ListNode node = new ListNode(0);
//        ListNode node1 = node;
//        if (temp == null || temp.next == null)
//            return temp;
//        while (temp != null && temp.next != null) {
//            ListNode next = temp.next.next; // 2 ->3
//            ListNode next1 = temp.next;
//            temp.next = null;
//            next1.next = temp;
//            node1.next = next1;
//            temp = next;
//            node1 = node1.next.next;
//
//        }
//        if(temp != null)
//            node1.next = temp;
//        return node.next;
//    }

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
