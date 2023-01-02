package com.example.datastructure.leetcode.problem.array;

import java.util.*;

//290. Word Pattern
public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> value = new HashMap<>();
        String[] split = s.split(" ");
        char[] ch = pattern.toCharArray();
        if (split.length != ch.length)
            return false;
        for (int i = 0; i < ch.length; i++) {
            char key = ch[i];
            String val = split[i];
            if (!value.containsKey(val)) {
                value.put(val, key);
            }

            if (!map.containsKey(key)) {
                map.put(key, val);
            }

            if (!map.get(key).equals(val) || value.get(val) != key)
                return false;
        }

        return true;
    }
}
