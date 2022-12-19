package com.example.datastructure.leetcode.problem.dynamic.programing.string;

import java.util.HashMap;
import java.util.Map;

// write a function that accepts a target string and array of string
// the function should return a boolean indicating whether or not the target can be constructed by concatenating elements of the array of string
// you may use elements of array of string as many as needed
public class CanConstruct {
    public static void main(String[] args) {
        String[] wordlist = new String[]{"ab", "abc", "cd", "def", "abcd"};
        System.out.println(canConstruct("abcdef", wordlist, new HashMap<>()));
        wordlist = new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"};
        System.out.println(canConstruct("skateboard", wordlist, new HashMap<>()));
        wordlist = new String[]{"a", "p", "ent", "enter", "ot", "o", "t"};
        System.out.println(canConstruct("enterpotentpot", wordlist, new HashMap<>()));
        wordlist = new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee", "eeeeeee", "eeeeeeee"};
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeee", wordlist, new HashMap<>()));
    }

    public static boolean canConstruct(String target, String[] wordBank, Map<String, Boolean> memo) {
        if (memo.containsKey(target))
            return memo.get(target);
        if (target.length() == 0)
            return true;
        for (String word : wordBank) {
            if (target.indexOf(word) == 0) {
                String substring = target.substring(word.length());
                if (canConstruct(substring, wordBank, memo))
                    return true;
            }
        }
        memo.put(target, false);
        return false;
    }


}
