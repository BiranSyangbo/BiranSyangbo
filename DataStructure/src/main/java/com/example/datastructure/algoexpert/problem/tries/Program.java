package com.example.datastructure.algoexpert.problem.tries;

import java.util.*;

class Program {
    // Do not edit the class below except for the
    // populateSuffixTrieFrom and contains methods.
    // Feel free to add new properties and methods
    // to the class.
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        public void populateSuffixTrieFrom(String str) {
            for (int i = str.length() - 1; i >= 0; i--) {
                int j = i;
                Map<Character, TrieNode> child = root.children;
                while (j < str.length()) {
                    char ch = str.charAt(j);
                    if (!child.containsKey(ch))
                        child.put(ch, new TrieNode());
                    child = child.get(ch).children;
                    j++;
                }
                child.put(endSymbol, null);
            }
        }

        public boolean contains(String str) {
            Map<Character, TrieNode> child = root.children;
            for (char ch : str.toCharArray()) {
                if (!child.containsKey(ch))
                    return false;
                child = child.get(ch).children;
            }
            return child.containsKey(endSymbol);
        }
    }
}
