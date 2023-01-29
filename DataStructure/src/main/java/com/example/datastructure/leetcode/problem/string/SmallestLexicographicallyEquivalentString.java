package com.example.datastructure.leetcode.problem.string;

import java.util.stream.IntStream;

//1061. Lexicographically Smallest Equivalent String
public class SmallestLexicographicallyEquivalentString {

    public static String smallestEquivalentString1(String s1, String s2, String baseStr) {
        int[] alphabet = IntStream.range(0, 26).toArray();
        for (int i = 0; i < s1.toCharArray().length; i++) {
            union(alphabet, s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }
        char[] chars = baseStr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (find(alphabet, chars[i] - 'a') + 'a');
        }
        return new String(chars);
    }

    static void union(int[] graph, int root, int child) {
        int r = find(graph, root);
        int c = find(graph, child);
        if (r < c) {
            graph[c] = r;
        } else
            graph[r] = c;
    }

    static int find(int[] graph, int root) {
        if (graph[root] == root)
            return root;
        return graph[root] = find(graph, graph[root]);
    }

    // My implmentation but issue exist in the function testcase6 will throw issue
    public static String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] alphabet = new int[26];
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = i;
        }
        for (int i = 0; i < s1.length(); i++) {
            int root = Math.max(s1.charAt(i), s2.charAt(i)) - 'a';
            int child = Math.min(s1.charAt(i), s2.charAt(i)) - 'a';
            while (root != 0 && root != alphabet[root]) {
                root = alphabet[root];
            }
            if (root > child)
                alphabet[root] = child;
            else
                alphabet[child] = root;
        }

        char[] ch = baseStr.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            int val = ch[i] - 'a';
            while (val != alphabet[val]) {
                val = alphabet[val];
            }
            ch[i] = (char) ('a' + val);
        }
        return new String(ch);
    }
}
