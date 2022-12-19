package com.example.datastructure.hash;

import java.util.*;

public class ExtendableHashing<K, V> {
    static class Page<K, V> {
        static int PAGE_SIZE = 20;
        private Map<K, V> m = new HashMap<>();
        int d = 0;

        boolean isFull() {
            return m.size() > PAGE_SIZE;
        }

        void put(K k, V v) {
            m.put(k, v);
        }

        V get(K k) {
            return m.get(k);
        }
    }

    int gd = 0;
    List<Page<K, V>> pp = new ArrayList<>();

    public ExtendableHashing() {
        pp.add(new Page<>());
    }

    Page<K, V> getPage(K k) {
        int h = k.hashCode();
        return pp.get(h & ((1 << gd) - 1));
    }

    public V get(K k) {
        return getPage(k).get(k);
    }

    public void put(K k, V v) {
        Page<K, V> page = getPage(k);
        if (page.isFull() && gd == page.d) {
            List<Page<K, V>> pp2 = new ArrayList<>(pp);
            pp.addAll(pp2);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {-1, 5, 10, 20, 28, 3};
        int[] arr2 = {26, 134, 135, 15, 17};
        smallestDifference(arr1, arr2);
    }

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int k = Integer.MAX_VALUE;
        int[] arr = new int[2];
        for (int i : arrayOne) {
            int j = 0;
            int val = Math.abs(i) - Math.abs(arrayTwo[j]);
            while (Math.abs(val) < k && j < arrayTwo.length - 1) {
                k = Math.min(k, Math.abs(val));
                arr[0] = i;
                arr[1] = arrayTwo[j++];
                val = Math.abs(i) - Math.abs(arrayTwo[j]);
            }
        }
        return arr;
    }
}
