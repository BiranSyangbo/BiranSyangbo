package com.example.datastructure.linked.list;

import java.util.NoSuchElementException;
import java.util.Objects;

public class DoublyLinkedList<T> {

    transient Node<T> head;

    transient Node<T> last;

    private int size;

    public void add(T element) {
        Node<T> l = last;
        Node<T> tNode = new Node<>(l, element, null);
        last = tNode;
        if (Objects.isNull(head))
            head = tNode;
        else {
            l.next = tNode;
        }
        size++;
    }

    public void addLast(T element) {
        Node<T> temp = last;
        Node<T> tNode = new Node<>(temp, element, null);
        this.last = tNode;
        if (this.head == null) {
            this.head = tNode;
        } else {
            temp.next = tNode;
        }
        size++;
    }

    public void addFirst(T element) {
        Node<T> temp = this.head;
        Node<T> tNode = new Node<>(null, element, temp);
        this.head = tNode;
        if (temp == null)
            last = tNode;
        else
            temp.prev = tNode;
        size++;
    }

    public void addAt(int index, T element) {
        if (index == size)
            add(element);
        else
            insertPrev(element, node(index));
    }

    /**
     * Insert Before the given {@param node }
     */
    private void insertPrev(T element, Node<T> node) {
        Node<T> pred = node.prev;
        Node<T> tNode = new Node<>(pred, element, node);
        node.prev = tNode;
        if (pred == null)
            head = tNode;
        else
            pred.next = tNode;
        size++;
    }

    /**
     * Return Node at the give position
     *
     * @return Node<T>
     */
    private Node<T> node(int index) {
        if (index < (size >> 1)) { // finding the half
            Node<T> x = head;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node<T> x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }


    public void display() {
        Node<T> temp = this.head;
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; temp != null; i++) {
            builder.append(temp.data);
            builder.append(" ");
            temp = temp.next;
        }
        builder.append("]");
        System.out.println(builder.toString());
    }


    public void removeFirst() {
        if (this.head == null)
            throw new NoSuchElementException("Node is not found");
        Node<T> temp = this.head;
        Node<T> next = temp.next;
        temp.data = null;
        temp.next = null;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        this.head = next;
    }

    public void removeLast() {
        if (this.last == null)
            throw new NoSuchElementException("Element Not exist");
        Node<T> last = this.last;
        Node<T> prev = last.prev;
        if (prev == null)
            head = null;
        else
            prev.next = null;
        this.last = prev;
        last.data = null;
        size--;
    }

    public void removeAt(int index) {
        if (!(index >= 0 && index < size))
            throw new NoSuchElementException();
        Node<T> node = node(index);
        if (node == null)
            throw new NoSuchElementException();
        unlink(node);
    }

    private void unlink(Node<T> node) {
        Node<T> next = node.next;
        Node<T> prev = node.prev;
        if (next == null)
            last = prev;
        else
            next.prev = prev;
        if (prev == null)
            this.head = next;
        else
            prev.next = next;
        node.data = null;
        node.prev = null;
        node.next = null;
        size--;
    }

    public void remove(T element) {
        for (Node<T> temp = this.head; temp != null; temp = temp.next) {
            if (delete(element, temp))
                break;
        }
    }

    /**
     * @param element
     */
    public void removeLastOccurrence(T element) {
        for (Node<T> temp = this.last; temp != null; temp = temp.prev) {
            if (delete(element, temp))
                break;
        }
    }

    public T getFirst() {
        Node<T> temp = this.head;
        if (temp == null)
            return null;
        else
            return temp.data;
    }

    public T getLast() {
        Node<T> temp = this.last;
        if (temp == null)
            return null;
        else
            return temp.data;
    }

    public T getAt(int index) {
        return node(index).data;
    }

    public int indexOf(T element) {
        int i = 0;
        for (Node<T> temp = this.head; temp != null; temp = temp.next, i++) {
            if (temp.data == element)
                return i;
        }
        return -1;
    }

    private boolean delete(T element, Node<T> temp) {
        T data = temp.data;
        if (element == null && null == data) {
            unlink(temp);
            return true;
        } else if (element != null) {
            if (element.equals(data)) {
                unlink(temp);
                return true;
            }
        }
        return false;
    }


    private class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T data, Node<T> next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
}

