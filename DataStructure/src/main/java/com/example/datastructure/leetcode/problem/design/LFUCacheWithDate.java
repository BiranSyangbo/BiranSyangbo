package com.example.datastructure.leetcode.problem.design;

import java.util.*;

public class LFUCacheWithDate {

    Map<Integer, Integer> cache;
    int capacity = 0;
    Map<Integer, Date> leastLFU;
    TreeMap<Date, Integer> date;
    Queue<Integer> leastKey;

    public LFUCacheWithDate(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        leastLFU = new HashMap<>(capacity);
        leastKey = new ArrayDeque<>(capacity);
        date = new TreeMap<>(Date::compareTo);
    }

    public int get(int key) {
        update(key);
        return cache.getOrDefault(key, -1);
    }

    void update(int key) {
        Date date = new Date();
        Date oldDate = leastLFU.get(key);
        leastLFU.put(key, date);
        if (oldDate != null)
            this.date.remove(oldDate);
        this.date.put(date, key);
    }

    void remove() {
        Date date = this.date.firstKey();
        Integer integer = this.date.get(date);
        this.date.remove(date);
        this.cache.remove(integer);
    }

    public void put(int key, int value) {
        if (!cache.containsKey(key) && cache.size() >= capacity) {
            remove();
        }
        if (capacity > 0) {
            cache.put(key, value);
            update(key);
        }

    }


    public static void main(String[] args) {
        LFUCacheWithDate cache = new LFUCacheWithDate(2);
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
