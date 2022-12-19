package com.example.datastructure.leetcode.problem.linkedlist;

public class MergeKSortedLinkedList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode listNode1 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode2 = new ListNode(2, new ListNode(6));
        ListNode[] arr = {listNode, listNode1, listNode2};
        ListNode listNode3 = mergeKLists(arr);
        while (listNode3 != null) {
            System.out.print(listNode3.val + " ");
            listNode3 = listNode3.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        return divideAndConquire(lists, 0, lists.length - 1);
    }

    public static ListNode divideAndConquire(ListNode[] lists, int start, int end) {
        if (start == end)
            return lists[start];
        int mid = start + (end - start) / 2;
        return mergeTwoList(divideAndConquire(lists, start, mid), divideAndConquire(lists, mid + 1, end));
    }

    public static ListNode mergeTwoList(ListNode first, ListNode second) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (first != null && second != null) {
            if (first.val < second.val) {
                temp.next = new ListNode(first.val);
                temp = temp.next;
                first = first.next;
            } else {
                temp.next = new ListNode(second.val);
                temp = temp.next;
                second = second.next;
            }
        }
        while (first != null) {
            temp.next = new ListNode(first.val);
            temp = temp.next;
            first = first.next;
        }

        while (second != null) {
            temp.next = new ListNode(second.val);
            temp = temp.next;
            second = second.next;
        }
        return head.next;
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
