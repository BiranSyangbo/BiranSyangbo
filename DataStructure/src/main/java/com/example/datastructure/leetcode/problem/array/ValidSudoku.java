package com.example.datastructure.leetcode.problem.array;


import java.util.HashSet;
import java.util.Set;

// 36. Valid Sudoku
public class ValidSudoku {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        System.out.println(set.add("abc"));
        System.out.println(set.add("abc"));
        System.out.println(set);

    }

    public static boolean isValidSudoku(char[][] arr) {
        Set<String> column = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                String key = "(" + arr[i][j] + ")";
                if (!column.add(key + i) || !column.add(key + j) || !column.add(i / 3 + key + j / 3)) {
                    return false;
                }
            }
        }
        return true;
    }
}
