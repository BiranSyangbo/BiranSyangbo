package com.example.datastructure.queue;

public class LinearQueue {
    private int count;
    private int rear;
    private int front;
    private int capacity;
    int[] data;

    public LinearQueue(int capacity) {
        this.rear = -1;
        this.front = 0;
        this.count = 0;
        this.capacity = capacity;
        data = new int[capacity];
    }

    public boolean add(int element) {
        if (isFull())
            return false;
        else {
            this.rear = (this.rear + 1) % capacity;
            data[this.rear] = element;
            count++;
            return true;
        }
    }

    public int get() {
        if (isEmpty()) {
            return -1;
        } else {
            int value = data[this.front];
            this.front = (this.front + 1) % capacity;
            count--;
            return value;
        }
    }

    public int peek() {
        return data[this.front];
    }

    private boolean isFull() {
        return size() == capacity;
    }

    private boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return count;
    }
}



