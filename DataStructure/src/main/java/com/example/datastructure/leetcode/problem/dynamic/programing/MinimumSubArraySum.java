package com.example.datastructure.leetcode.problem.dynamic.programing;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;


//907. Sum of Subarray Minimums
public class MinimumSubArraySum {
    public static void main(String[] args) {
        int[] arr = {3,1,2,4};
        int actual = sumSubarrayMinss(arr);
        System.out.println(actual);
        assertEquals(444, actual);
    }

    static int sumSubarrayMins(int[] arr) {
        int mod = 1000000007;
        int len = arr.length;
        long sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= len; i++) {
            while (!stack.isEmpty() && (i == len || arr[stack.peek()] >= arr[i])) {
                int mid = stack.pop();
                int leftBoundary = stack.isEmpty() ? -1 : stack.peek();
                int rightBoundary = i;
                long count = (long) (mid - leftBoundary) * (rightBoundary - mid) * mod;
                sum += (count * arr[mid]) % mod;
                sum %= mod;
            }
            stack.push(i);
        }
        return (int) sum;
    }

    static int sumSubarrayMinss(int[] arr) {
        final int MOD = 1000000007;
        Stack<Integer> st = new Stack<>();
        long sumOfMinimums = 0;

        for (int i = 0; i <= arr.length; i++) {
            while (!st.empty() && (i == arr.length || arr[st.peek()] >= arr[i])) {
                int mid = st.pop();
                int leftBoundary = st.empty() ? -1 : st.peek();
                int rightBoundary = i;

                long count = (mid - leftBoundary) * (rightBoundary - mid) % MOD;
                System.out.println("Count = " + count + "  " + " Val= " + arr[mid]);
                sumOfMinimums += (count * arr[mid]) % MOD;
                sumOfMinimums %= MOD;
            }
            st.push(i);
        }

        return (int) sumOfMinimums;
    }
}
