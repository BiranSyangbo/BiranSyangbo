package com.example.datastructure.leetcode.problem.design;

import java.util.*;

public class LFUCache {

    Map<Integer, Integer> cache;
    int capacity = 0;
    Map<Integer, Integer> leastLFU;
    Queue<Integer> leastKey;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        leastLFU = new HashMap<>(capacity);
        leastKey = new ArrayDeque<>(capacity);
    }

    public int get(int key) {
        leastLFU.computeIfPresent(key, (k, v) -> leastLFU.getOrDefault(k, 0) + 1);
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        rotateKey(key);
        if (cache.size() >= capacity) {
            Integer poll = leastKey.poll();
            leastLFU.remove(poll);
            cache.remove(poll);
        }
        leastLFU.compute(key, (k, v) -> leastLFU.getOrDefault(k, 0) + 1);
        cache.put(key, value);
    }

    private void rotateKey(int key) {
        leastKey.offer(-1);
        while (leastKey.peek() != -1 && leastLFU.getOrDefault(leastKey.peek(), 0) > 1) {
            Integer poll = leastKey.poll();
            leastKey.offer(poll);
        }
        leastKey.remove(-1);
        leastKey.offer(key);
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        System.out.println(cache.get(1));
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        System.out.println(cache.get(4));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }
}
