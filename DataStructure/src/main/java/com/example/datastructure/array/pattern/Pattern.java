package com.example.datastructure.array.pattern;

public class Pattern {
    public static void main(String[] args) {
        int n = 5;
        AsteriskAndDollarPyramid(n);
    }

    //"""
    //    1
    //    3 2
    //    4 5 6
    //    10 9 8 7
    //    11 12 13 14 15
    //"""
    private static void OddEvenPyramid(int n) {
        int count = 1;
        int reverse;
        for (int i = 1; i <= n; i++) {
            reverse = count + i - 1;
            for (int j = 0; j < i; j++, count++) {
                if (i % 2 != 0)
                    System.out.print(count + " ");
                else
                    System.out.print(reverse-- + " ");
            }
            System.out.println();
        }
    }
    // """
    //    *
    //    & *
    //    * & *
    //    & * & *
    //    * & * & *
    //"""
    private static void AsteriskAndDollarPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if ((i+j) % 2 != 0)
                    System.out.print("* ");
                else
                    System.out.print("& ");
            }
            System.out.println();
        }
    }
}
