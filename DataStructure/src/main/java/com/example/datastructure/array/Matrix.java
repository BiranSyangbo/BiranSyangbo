package com.example.datastructure.array;

import java.util.Random;

public class Matrix {

    public static void main(String[] args) {
        int[][] array2D = new int[3][3];
        int n = 3;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Random random = new Random();
                array2D[i][j] = random.nextInt(9) + 1;
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array2D[i][j] + " ");
            }
            System.out.println(" \n ");
        }


    }

}
