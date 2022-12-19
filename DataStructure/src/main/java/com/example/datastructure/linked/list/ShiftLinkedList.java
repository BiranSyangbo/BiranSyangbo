package com.example.datastructure.linked.list;

public class ShiftLinkedList {

    public static void main(String[] args) {
        LinkedList linkedList0 = new LinkedList(0);
        LinkedList linkedList1 = new LinkedList(1);
        LinkedList linkedList2 = new LinkedList(2);
        LinkedList linkedList3 = new LinkedList(3);
        LinkedList linkedList4 = new LinkedList(4);
        LinkedList linkedList5 = new LinkedList(5);
        LinkedList linkedList6 = new LinkedList(6);
        linkedList5.next = linkedList6;
        linkedList4.next = linkedList5;
        linkedList3.next = linkedList4;
        linkedList2.next = linkedList3;
        linkedList1.next = linkedList2;
        linkedList0.next = linkedList1;
        LinkedList linkedList = shiftLinkedList(linkedList0, 15);
        while (linkedList != null) {
            System.out.print(linkedList.value + " ");
            linkedList = linkedList.next;
        }
    }

    public static LinkedList shiftLinkedList(LinkedList head, int k) {
        int size = 1;
        LinkedList copy = head;
        while (copy.next != null) {
            size++;
            copy = copy.next;
        }
        int offset = Math.abs(k) % size;
        if (offset == 0)
            return head;
        int newTailPosition = (k > 0) ? size - offset : offset;
        copy.next = head;
        while (newTailPosition != 0) {
            copy = copy.next;
            newTailPosition--;
        }
        LinkedList temp = copy.next;
        copy.next = null;
        return temp;
    }

    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }
    }
}
