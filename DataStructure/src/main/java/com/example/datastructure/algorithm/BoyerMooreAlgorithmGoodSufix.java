package com.example.datastructure.algorithm;

public class BoyerMooreAlgorithmGoodSufix {

    public static void main(String[] args) {
//        char[] text = "ABAAAABAACD".toCharArray();
//        char[] pat = "ABBABAB".toCharArray();
//        System.out.println("Result");
//        search(text, pat);
    }

    private static void search(char[] txt, char[] pat) {
        int s = 0, j;
        int m = pat.length;
        int n = txt.length;
        int[] bpos = new int[m + 1];
        int[] shift = new int[m + 1];

        for (int i = 0; i < m + 1; i++)
            shift[i] = 0;

        preprocess_strong_suffix(pat, shift, bpos, m);
        preprocessor_case2(shift, bpos, pat, m);
        while (s <= (n - m)) {
            j = m - 1;
            while (j >= 0 && pat[j] == txt[s + j]) {
                j--;
            }

            if (j < 0) {
                System.out.printf("Patter occurs at shift = %d\n", s);
                s += shift[0];
            } else {
                s += shift[j + 1];
            }
        }
    }

    // e.g.
    // pattern = "ABBABAB", m = 7;
    //
    // preprocessing for strong good suffix rule
    // m is the length of pattern array;
    private static void preprocess_strong_suffix(char[] pat, int[] shift, int[] bpos, int m) {
        int i = m, j = m + 1; // i = 7;6;54, j = 8;7;7;6;
        bpos[i] = j; // 7=8, 6=7;
        while (i > 0) {
            /**
             * If character at position i-1 is not equivalent to character at j-1,
             * then continue search to right of the pattern for border;
             */

            while (j <= m && pat[i - 1] != pat[j - 1]) { // 8 <= 7 =>(false); 7<= 7 && (pat[5] = A) == (pat[6] = B) => (true);
                // 7 <= 7 &&( pat[4]= B ) == (Pat[6] = B) => (false);
                // 7 <= 7 && (pat[3] = A) == (pat[5] = A)

                /**
                 * the character preceding the occurrence of t in patter P is different that
                 * the mismatching character in P, we stop skipping the occurrences and shift the pattern from i to j
                 */
                if (shift[j] == 0) { // true
                    shift[j] = j - i; // 7 = 6;
                }

                // Update the position of the next border;
                j = bpos[j]; // j= 8 ;
            }

            /**
             * p[i-1] matched with p[j-1], border is found. store the begging
             * position of border
             */
            i--; // 6;5; 4
            j--; // 7 , 7;6
            bpos[i] = j; // 6 =7; 5=7; 4 = 6;

        }
    }

    private static void preprocessor_case2(int[] shift, int[] bpos, char[] pat, int m) {
        int j = bpos[0];
        for (int i = 0; i <= m; i++) {
            if (shift[i] == 0) {
                shift[i] = j;
            }

            if (i == j) {
                j = bpos[j];
            }
        }
    }
}
