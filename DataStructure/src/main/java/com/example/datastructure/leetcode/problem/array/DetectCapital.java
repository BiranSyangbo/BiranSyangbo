package com.example.datastructure.leetcode.problem.array;

//520. Detect Capital
public class DetectCapital {

    public static boolean detectCapitalUse(String word) {
        char[] ch = word.toCharArray();
        if (ch.length < 2)
            return true;
        int i = 1;
        int j = ch.length - 1;
        boolean isCapital = Character.isUpperCase(ch[i - 1]);
        while (i <= j) {
            boolean isUpperCase = Character.isUpperCase(ch[i]) || Character.isUpperCase(ch[j]);
            boolean isLowerCase = Character.isLowerCase(ch[i]) || Character.isLowerCase(ch[j]);
            boolean isLastUpperCase = Character.isUpperCase(ch[ch.length - 1]);
            if (isCapital) {
                if (isLastUpperCase) {
                    if (isLowerCase)
                        return false;
                } else if (isUpperCase)
                    return false;
            } else if (isUpperCase)
                return false;
            i++;
            j--;
        }
        return true;
    }

//    public static boolean detectCapitalUse(String word) {
//        char[] ch = word.toCharArray();
//        if (ch.length < 2)
//            return true;
//
//        int j = ch.length - 1;
//        int i = 0;
//        boolean isCapital = Character.isUpperCase(ch[i]);
//        while (i < j) {
//            if (isCapital) {
//                if (Character.isUpperCase(ch[j])) {
//                    while (i <= j) {
//                        if (Character.isLowerCase(ch[i]) || Character.isLowerCase(ch[j]))
//                            return false;
//                        i++;
//                        j--;
//                    }
//                    return true;
//                } else {
//                    if (Character.isLowerCase(ch[i + 1])) {
//                        i++;
//                    } else
//                        return false;
//                }
//
//            } else {
//                while (i <= j) {
//                    if (Character.isUpperCase(ch[i]) || Character.isUpperCase(ch[j]))
//                        return false;
//                    i++;
//                    j--;
//                }
//                break;
//            }
//        }
//        return true;
//    }
}
