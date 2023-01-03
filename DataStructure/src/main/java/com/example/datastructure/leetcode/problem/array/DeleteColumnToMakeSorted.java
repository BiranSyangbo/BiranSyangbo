package com.example.datastructure.leetcode.problem.array;


//944. Delete Columns to Make Sorted
public class DeleteColumnToMakeSorted {

    public static int minDeletionSize(String[] strs) {
        int min = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            int j = 1;
            int k = strs.length - 1;
            while (j <= k) {
                if (strs[j].charAt(i) < strs[j - 1].charAt(i) || strs[k].charAt(i) < strs[k - 1].charAt(i)) {
                    min++;
                    break;
                } else {
                    j++;
                    k--;
                }
            }
        }
        return min;
    }
}
