package com.example.datastructure.leetcode.problem.string;

//TAG:- String, Array
public class RemoveAllAdjacentDuplicateInString {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }

    public static String removeDuplicates(String s) {
        int j = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            arr[j] = arr[i];
            if (j > 0 && arr[j] == arr[j - 1]) {
                j -= 2;
            }
            j++;
        }
        return new String(arr, 0, j);
    }

    // My solution
//    public String removeDuplicates(String s) {
//        StringBuilder builder = new StringBuilder(s);
//        for (int i = 0; i < builder.length() - 1; ) {
//            if (builder.charAt(i) == builder.charAt(i + 1)) {
//                builder.deleteCharAt(i + 1);
//                builder.deleteCharAt(i);
//                if (i > 0) i--;
//            } else
//                i++;
//        }
//        return builder.toString();
//    }
}
