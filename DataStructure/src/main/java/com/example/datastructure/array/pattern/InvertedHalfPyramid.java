package com.example.datastructure.array.pattern;

/**

 *  *  *  *  *
 *  *  *  *
 *  *  *
 *  *
 *

 */
public class InvertedHalfPyramid {
    public static void main(String[] args) {
        int n = 5;
        invertedAstrikPyramid(n);
    }

    private static void invertedAstrikPyramid(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*  ");
            }
            System.out.println();
        }
    }
}
