package com.example.datastructure.leetcode.problem.tries;

import java.util.*;


public class ConcatenatedWord {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            wordBreak(word);
        }
        for (String word : words) {
            if (contains(word, 0, 0))
                result.add(word);
        }

        return result;
    }

    private final TrieNode root;

    public ConcatenatedWord() {
        root = new TrieNode();
    }

    public boolean contains(String s, int count, int index) {
        TrieNode children = this.root;
        for (int i = index; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (children.children.get(ch) == null) {
                return false;
            }
            if (children.children.get(ch).isEndTries) {
                if (i == s.length() - 1) return count >= 1;
                if (contains(s, count + 1, i + 1))
                    return true;
            }
            children = children.children.get(ch);
        }
        return false;
    }

    public void wordBreak(String s1) {
        TrieNode children = this.root;
        for (char ch : s1.toCharArray()) {
            if (!children.children.containsKey(ch)) {
                children.children.put(ch, new TrieNode());
            }
            children = children.children.get(ch);
        }
        children.isEndTries = true;
    }


    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndTries;

        public TrieNode() {
            this.children = new HashMap<>();
            this.isEndTries = false;
        }
    }

    // Dynamic Programming
    public List<String> findAllConcatenatedWordsInADict1(String[] words) {
        final Set<String> dictionary = new HashSet<>(Arrays.asList(words));
        final List<String> answer = new ArrayList<>();
        for (final String word : words) {
            final int length = word.length();
            final boolean[] dp = new boolean[length + 1];
            dp[0] = true;
            for (int i = 1; i <= length; ++i) {
                for (int j = (i == length ? 1 : 0); !dp[i] && j < i; ++j) {
                    dp[i] = dp[j] && dictionary.contains(word.substring(j, i));
                }
            }
            if (dp[length]) {
                answer.add(word);
            }
        }
        return answer;
    }

}
