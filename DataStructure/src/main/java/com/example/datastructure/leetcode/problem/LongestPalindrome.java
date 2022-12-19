package com.example.datastructure.leetcode.problem;

//Mancher Algorithm + Custom
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(findLongestPalindromeUsingManacherAlgorithm("aacabdkacaa"));;
//        System.out.println(longestPalindrome("babad"));
    }

    public static void findLongestPalindromeUsingBruteForce(String s) {
        int n = s.length();
        int maxLength = 1, start = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int flag = 1;
                for (int k = 0; k < (j - i + 1) / 2; k++) { // 0-0+1/2 = 1
                    System.out.println(s.charAt(i + k) + "" + (i + k) + " = " + (j - k) + "" + s.charAt(j - k));
                    if (s.charAt(i + k) != s.charAt(j - k)) {
                        flag = 0;
                        break;
                    }
                }

                if (flag != 0 && (j - i - 1) > maxLength) {
                    start = i;
                    maxLength = j - i - 1;
                }
            }
        }
        // daabddfddbegtd
        System.out.println(s.substring(start, start + maxLength));
    }


    public static String findLongestPalindromeUsingManacherAlgorithm(String s) {
        int size = 2 * s.length() + 3;
        char[] ch = new char[size];
        ch[0] = '@';
        ch[size - 1] = '$';

        int t = 1;
        for (char c : s.toCharArray()) {
            ch[t++] = '#';
            ch[t++] = c;
        }
        ch[t] = '#';

        int maxLen = 0, maxRight = 0, start = 0, center = 0;
        int p[] = new int[size];
        for (int i = 1; i < size - 1; i++) {
            if (i < maxRight) {
                p[i] = Math.min(maxRight - i, p[2 * center - i]);
            }

            while (ch[i + p[i] + 1] == ch[i - p[i] - 1]) {
                p[i]++;
            }

            if (i + p[i] > maxRight) {
                center = i;
                maxRight = i + p[i];
            }

            if (p[i] > maxLen) {
                start = (i - p[i] - 1) / 2;
                maxLen = p[i];
            }
        }
        return s.substring(start, start + maxLen);

    }

}
