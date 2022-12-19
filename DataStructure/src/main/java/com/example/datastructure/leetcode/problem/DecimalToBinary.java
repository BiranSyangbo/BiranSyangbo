package com.example.datastructure.leetcode.problem;

public class DecimalToBinary {
    public static void main(String[] args) {
        System.out.println(decimalToBinary(22));
    }

    public static String decimalToBinary(int numbers) {
        if (numbers == 0) {
            return "";
        }
        String s = numbers % 2 + "";
        return decimalToBinary(numbers / 2) + s;
    }
}
