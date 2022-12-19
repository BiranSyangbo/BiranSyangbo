package com.example.datastructure.leetcode.problem;

public class MakeStringGreat1544 {

    public static void main(String[] args) {

        String abc = String.format("?portId=%1$s", "abc");
        System.out.println(abc);

        System.out.println(makeGood("leEeetcodeDd"));
    }

    public static String makeGood(String s) {
        StringBuilder builder = new StringBuilder(s);
        int j;
        int i = 0;
        while (i < builder.length() - 1) {
            char c = builder.charAt(i);
            if ((c + 32 == builder.charAt(i + 1)) || (c - 32 == builder.charAt(i + 1))) {
                j = i - 1;
                builder.deleteCharAt(i + 1);
                builder.deleteCharAt(i);
                i = j < 0 ? 0 : j;
            } else
                i++;
        }
        return builder.toString();
    }
}
