package com.example.datastructure.leetcode.problem.array;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//520. Detect Capital
public class DetectCapital {

    public static boolean detectCapitalUse(String word) {
        Matcher.quoteReplacement("").matches("abc");
        char[] ch = word.toCharArray();
        if (ch.length < 2)
            return true;
        int i = 1;
        int j = ch.length - 1;
        boolean isCapital = ch[i - 1] >= 'A' && ch[i - 1] <= 'Z';
        while (i < ch.length) {
//            if ((isCapital && ch[i] >= 'A' && ch[i] <= 'Z' && ch[j] >= 'A' && ch[j] <= 'Z') || (!isCapital && (ch[i] >= 'a' && ch[i] <= 'z') && ch[j] >= 'a' && ch[j] <= 'z')) {
//                i++;
//                j--;
//            } else {
//                return false;
//            }


            i++;

        }
        return true;
    }
}
