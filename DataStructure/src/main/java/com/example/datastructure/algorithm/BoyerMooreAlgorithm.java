package com.example.datastructure.algorithm;

import java.util.Arrays;

public class BoyerMooreAlgorithm {

    public static void main(String[] args) {
        char txt[] = "ABCAAABCDAAA".toCharArray();
        char pat[] = "ACA".toCharArray();
        boyerAlgorithm(txt, pat);
    }

    static void badCharacterHeuristics(char[] pat, int size, int[] badchar) {
        Arrays.fill(badchar, -1);
        for (int i = 0; i < size; i++) {
            badchar[pat[i]] = i;
        }
    }

    public static void boyerAlgorithm(char[] str, char[] pat) {
        int m = pat.length;
        int n = str.length;

        int badchar[] = new int[256];

        badCharacterHeuristics(pat, m, badchar);
        int s = 0;

        while (s <= (n - m)) {
            int j = m - 1;
            while (j >= 0 && pat[j] == str[s + j])
                j--;

            if (j < 0) {
                System.out.println("Patter match at shift " + s);
                s += ((s + m) < n) ? m - badchar[str[s + m]] : 1;
            } else {
                s += Math.max(1, j - badchar[str[j + s]]);
            }
        }

    }
}
