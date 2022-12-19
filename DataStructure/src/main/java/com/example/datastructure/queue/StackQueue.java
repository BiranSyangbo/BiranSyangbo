package com.example.datastructure.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackQueue<T> {
    Queue<T> q1, q2;

    public StackQueue() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    public void add(T element) {
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }
        q1.add(element);
        while (!q2.isEmpty()) {
            q1.add(q2.poll());
        }
    }
}
