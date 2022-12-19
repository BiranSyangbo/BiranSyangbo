package com.example.datastructure.leetcode.problem.string;

public class ReverseStringWithRecursion {

    public static void main(String[] args) {
        String biran1 = "The simple engineer";
//        String biran = reverseString(biran1, 0);
//        System.out.println("= " + biran);
        System.out.println(reverseStringWithoutIndex(biran1));
    }

    public static String reverseString(String s, int l) {
        if (l == s.length() - 1)
            return String.valueOf(s.charAt(l));
        return reverseString(s, l + 1) + s.charAt(l);
    }

    public static String reverseStringWithoutIndex(String ss) {
        if (ss.length() == 0)
            return ss;
        return reverseStringWithoutIndex(ss.substring(1)) + ss.charAt(0);

//                ss.substring(ss.length() - 1) + reverseStringWithoutIndex(ss.substring(0, ss.length() - 1));
    }

}
