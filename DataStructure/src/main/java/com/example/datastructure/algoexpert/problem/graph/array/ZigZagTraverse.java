package com.example.datastructure.algoexpert.problem.graph.array;

import java.util.ArrayList;
import java.util.List;

public class ZigZagTraverse {

    //[1, 3, 4, 10],
    //[2, 5, 9, 11],
    //[6, 8, 12, 15],
    //[7, 13, 14, 16]

    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        int row = 0;
        int col = 0;
        int colSize = array.get(row).size();
        List<Integer> zigzag = new ArrayList<>(colSize * array.size());
        boolean down = true;
        while (row >= 0 && row <= array.size() - 1 && col >= 0 && col <= colSize - 1) {
            zigzag.add(array.get(row).get(col)); // 11
            if (down) {
                if (col == 0 || row == array.size() - 1) {
                    down = false;
                    if (row == array.size() - 1)
                        col++;
                    else
                        row++;
                } else {
                    row++;
                    col--;
                }
            } else {
                if (row == 0 || col == colSize - 1) {
                    down = true;
                    if (col == colSize - 1)
                        row++;
                    else
                        col++;
                } else {
                    col++;
                    row--;
                }
            }
        }
        return zigzag;

    }
//    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
//        List<Integer> zigzag = new ArrayList<>(array.size() * array.get(0).size());
//        int i = 0;
//        int j = 0;
//        int s = array.get(i).size();
//        while (i < array.size() && j < s) {
//            if ((i + j) % 2 == 0) {
//                while (i >= 0 && i < array.size() && j >= 0 && j < s) {
//                    zigzag.add(array.get(i).get(j));
//                    i++;
//                    if (j > 0) {
//                        j--;
//                    } else {
//                        break;
//                    }
//                }
//                if (i >= array.size()) {
//                    i = array.size() - 1;
//                    j += 2;
//                }
//                if (i >= array.size() && j >= s)
//                    break;
//            } else {
//                while (i >= 0 && i < array.size() && j >= 0 && j < s) {
//                    zigzag.add(array.get(i).get(j));
//                    j++;
//                    if (i > 0)
//                        i--;
//                    else
//                        break;
//                }
//                if (j >= s) {
//                    j = s - 1;
//                    i += ;
//                }
//                if (i >= array.size() && j >= s)
//                    break;
//            }
//        }
//        System.out.println(zigzag);
//        return zigzag;
//    }
}
