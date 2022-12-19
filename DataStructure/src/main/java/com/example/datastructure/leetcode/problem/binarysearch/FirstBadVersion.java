package com.example.datastructure.leetcode.problem.binarysearch;

public class FirstBadVersion {

    public static void main(String[] args) {
        int start = 0;
        int end = 100;
        int count = 0;
        while (start < end) {
            int mid = (start + end) / 2;
            int midd = (start + (end - start) / 2);
            System.out.println(start + " " + end + "   = " + mid);
            System.out.println(start + " " + end + "   = " + midd);
            if (midd < 100) {
                start = midd + 1;
            } else {
                end = midd - 1;
            }
            count++;

        }
        System.out.println(count);
    }
}
