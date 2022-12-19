package com.example.datastructure.leetcode.problem.dynamic.programing;

import java.util.List;

public class FinbonaciUsingTable {
    public static void main(String[] args) {
        System.out.println(fib(5));
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        numbers.stream().filter(number -> number % 2 == 0)
                .map(number -> {
                    System.out.print(number);
                    return number * 2;
                })
                .limit(1)
                .forEach(System.out::println);
    }

    public static long fib(int n) {
        long[] arr = new long[n + 1];
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}
