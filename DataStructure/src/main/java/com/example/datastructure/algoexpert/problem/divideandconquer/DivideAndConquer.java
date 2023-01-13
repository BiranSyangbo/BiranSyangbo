package com.example.datastructure.algoexpert.problem.divideandconquer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DivideAndConquer {

    public static void main(String[] args) {
//        int[] arr = {69, 65, 62, 64, 70, 68, 69, 67, 60, 65, 69, 62, 65, 65, 61, 66, 68, 61, 65, 63, 60, 66, 68, 66, 67, 65, 63, 65, 70, 69, 70, 62, 68, 70, 60, 68, 65, 61, 64, 65, 63, 62, 62, 62, 67, 62, 62, 61, 66, 69};
//        int[] arr = {1, 1, 1, 1, 1, 1, 1};
//
//        process(arr, 0, arr.length);
    }


    public static void process(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (end + start) / 2;
            System.out.println(arr[mid]);
            process(arr, start, mid);
            process(arr, mid + 1, end);
        }

    }
}
