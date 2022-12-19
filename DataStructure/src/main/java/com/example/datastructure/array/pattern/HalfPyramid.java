package com.example.datastructure.array.pattern;

/**
 * e.g.
 * <p>
 * *
 * * *
 * * * *
 * * * * *
 * * * * * *
 */
public class HalfPyramid {
    public static void main(String[] args) {
        int n = 5;
//        halfAsteriskPyramid(n);
//        System.out.println("\n\n\n");
//        halfNoPyramid(n);
//        System.out.println("\n\n\n");
//        halfPyramidWithLetterWithCharacterCalculation('E');
////
//
//        halfPyramid(n);
//        System.out.println("\n\n ");
//        halfPyramidWithNo(n);

//        halfPyramidWithDifferentCondition(n);


    }

    private static void halfPyramidWithDifferentCondition(int n) {
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; j++) {
                if (j <= n - i)
                    System.out.print(" ");
                else
                    System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    // Pattern"""
    //          1
    //       2 2
    //     3 3 3
    //   4 4 4 4
    // 5 5 5 5 5
    //"""
    private static void halfPyramidWithNo(int n) {
        int k = 0;
        for (int i = 1; i <= n; i++, k = 0) {
            for (int space = 1; space <= n - i; ++space) {
                System.out.print("  ");
            }
            while (k != i) {
                System.out.print(i + " ");
                k++;
            }
            System.out.println();
        }
    }

    //    """
    //
    //          *
    //        * *
    //      * * *
    //    * * * *
    //  * * * * *
    //"""
    private static void halfPyramid(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    //   """
    //    A
    //    B B
    //    C C C
    //    D D D D
    //    E E E E E
    //    """
    private static void halfPyramidWithLetterWithCharacterCalculation(char input) {
        char character = 'A';
        for (int i = 0; i < (input - 'A') + 1; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(character + " ");
            }
            ++character;
            System.out.println();
        }
    }

    //   """
    //    A
    //    B B
    //    C C C
    //    D D D D
    //    E E E E E
    //    """
    private static void halfPyramidWithLetter(int n) {
        int ch = 'A';
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print((char) ch + " ");
            }
            ch++;
            System.out.println(" ");
        }
    }

    //    """
    //    1
    //    1 2
    //    1 2 3
    //    1 2 3 4
    //    1 2 3 4 5
    // """
    private static void halfNoPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    // """
    //    *
    //    * *
    //    * * *
    //    * * * *
    //    * * * * *
    //"""
    private static void halfAsteriskPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }


}
