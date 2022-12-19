package com.example.datastructure.array.pattern;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InvertedFullPyramid {

    public static void main(String[] args) {
        int n = 5;
        middleEmptyPattern(n);
        int [] array = new int[5];
    }

    //    """
    //        *                 *
    //        * *             * *
    //        * * *         * * *
    //        * * * *     * * * *
    //        * * * * * * * * * *
    //    """
    private static void middleEmptyPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n * 2; j++) {
                if (j <= i || j > 2 * n - i)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    //    """
    //   * * * * * * * * *
    //    * * * * * * *
    //      * * * * *
    //        * * *
    //          *
    //"""
    private static void invertedPyramid(int n) {
        for (int i = n; i >= 1; i--) {
            for (int space = n; space >= i; space--) {
                System.out.print("  ");
            }
            for (int j = (i * 2) - 1; j > 0; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
