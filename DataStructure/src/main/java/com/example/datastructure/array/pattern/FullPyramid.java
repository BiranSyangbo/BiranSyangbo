package com.example.datastructure.array.pattern;

public class FullPyramid {

    public static void main(String[] args) {
        int n = 9;
//        fullPyramidWithAsterisk(n);
        pyramid(n);
    }




    private static void pyramid(int n) {
        int k = 0, count = 0, count1 = 0;
        for (int i = 1; i <= n; i++) {
            for (int space = 1; space <= n - i; space++) {
                System.out.print("  ");
                ++count;
            }
            while (k != (2 * i - 1)) {
                if (count <= n - 1) {
                    System.out.print((i + k) + " ");
                    count++;
                } else {
                    count1++;
                    System.out.print((i + k - 2 * count1) + " ");
                }
                k++;
            }
            count = count1 = k = 0;
            System.out.println();

        }
    }

    //    """
//                1
//              1 2 1
//            2 3 4 3 2
//          4 5 6 7 6 5 4
//        7 8 9 10 11 10 9 8 7
//   """
    private static void fullPyramidWithNumbers(int n) {
        int k = 0;
        int a = 1;
        int b = 1;
        int m = 0;
        for (int i = 1; i <= n; i++, k = 0, m = 0) {
            for (int space = 1; space <= n - i; ++space) {
                System.out.print("  ");
            }
            while (k != i) {
                System.out.print(a + " ");
                a++;
                k++;
            }
            a--;
            b = a - 1;
            while (m != i - 1) {
                System.out.print(b + " ");
                b--;
                m++;
            }
            System.out.println();
        }
    }

    //    """
//                    *
//                  * * *
//                * * * * *
//              * * * * * * *
//            * * * * * * * * *
//            """;
    private static void fullPyramidWithAsterisk(int n) {
        int k = 0;
        for (int i = 1; i <= n; i++, k = 0) {
            for (int space = 1; space <= n - i; ++space) {
                System.out.print("  ");
            }
            while (k != 2 * i - 1) {
                System.out.print("* ");
                k++;
            }
            System.out.println();
        }
    }
}
