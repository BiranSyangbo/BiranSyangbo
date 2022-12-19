package com.example.datastructure.leetcode.problem;

import java.util.*;

public class LetterCombination {

    public static void main(String[] args) {
        System.out.println(letterCombinations("239"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        int length = digits.length();
        if (length == 0) {
            return ans;
        }
        List<String> chars = new ArrayList<>();
        for (char c : digits.toCharArray()) {
            if (Character.isDigit(c) && c != '1') {
                chars.add(charList().get(c));
            }
        }
        if (chars.size() < 2)
            return chars;

        // abc, def, ghi
//        for (int i = 0; i < 3; i++) {
//            String s = chars.get(0);  // abc
//            for (int j = 1; j < chars.size(); j++) {
//                int k = 0;
//                while (k < chars.get(j).length()) {  // def
//                    String val = String.valueOf(s.charAt(i)); // a
//                    val += chars.get(j).charAt(k); // ad, ae, af,
//                    ans.add(val);
//                    k++;
//                }
//            }
//        }

        // abc, def, ghi
        for (int i = 0; i < 3; i++) {
            String s = chars.get(0);  // abc
            for (int j = 1; j < chars.size(); j++) {
                int k = 0;
                while (k < chars.get(j).length()) {  // def
                    String val = String.valueOf(s.charAt(i)); // a
                    val += chars.get(j).charAt(k); // ad, ae, af,
                    ans.add(val);
                    k++;
                }
            }
        }

        return ans;
    }

    static Map<Character, String> charList() {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return map;
    }
}
