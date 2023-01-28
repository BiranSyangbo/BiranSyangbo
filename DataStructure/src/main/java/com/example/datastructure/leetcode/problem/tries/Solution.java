package com.example.datastructure.leetcode.problem.tries;

import java.util.*;

class TrieNode {
    TrieNode[] children;
    boolean isWord;

    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }
}

public class Solution {
    TrieNode root;

    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.isWord = true;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        root = new TrieNode();
        List<String> res = new ArrayList<>();

        for (String word : words) {
            insert(word);
        }

        for (String word : words) {
            if (search(word, 0, 0)) {
                res.add(word);
            }
        }
        return res;
    }

    public boolean search(String word, int index, int count) {
        TrieNode cur = root;
        for (int i = index; i < word.length(); i++) {
            int j = word.charAt(i) - 'a';
            if (cur.children[j] == null) {
                return false;
            }
            if (cur.children[j].isWord) {
                if (i == word.length() - 1) {
                    return count >= 1;
                }
                if (search(word, i + 1, count + 1)) {
                    return true;
                }
            }
            cur = cur.children[j];
        }
        return false;
    }
}