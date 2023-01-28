package com.example.datastructure.leetcode.problem.tries;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {
    private final TrieNode root;

    public WordBreak() {
        root = new TrieNode();
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        for (String s1 : wordDict) {
            TrieNode children = this.root;
            for (char ch : s1.toCharArray()) {
                if (!children.children.containsKey(ch)) {
                    children.children.put(ch, new TrieNode());
                }
                children = children.children.get(ch);
            }
            children.isEndTries = true;
        }

        TrieNode children = this.root;
        for (char ch : s.toCharArray()) {
            if (children.isEndTries) {
                children = this.root;
            } else if (!children.children.containsKey(ch))
                return false;
            children = children.children.getOrDefault(ch, new TrieNode());
        }
        return children.isEndTries;
    }


    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndTries;
        private int occures;

        public TrieNode() {
            this.children = new HashMap<Character, TrieNode>();
            this.isEndTries = false;
            this.occures = 0;
        }
    }
}
