package com.example.datastructure.leetcode.problem.linkedlist;

import java.util.*;

// 83. Remove Duplicates from Sorted List
public class DeleteDuplicateNode {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(1)));
//        deleteDuplicates(listNode);
        System.out.println(Arrays.toString(twoNumberSum(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 10)));
    }

    public static int[] twoNumberSum(int[] array, int targetSum) {
        Map<Integer, Integer> memo = new HashMap<>();
        for (int i : array) {
            int complement = targetSum - i;
            if (memo.containsKey(complement)) {
                return new int[]{memo.get(complement), complement};
            } else {
                memo.put(i, complement);
            }
        }
        return new int[0];
    }

    public static ListNode deleteDuplicates(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = new ListNode(-1);
        temp.next = head;
        while (temp.next != null) {
            list.add(temp.val);
            if (temp.next.val != -1 && list.contains(temp.next.val)) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }

        }
        return head;
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
