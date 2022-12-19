package com.example.datastructure.leetcode.problem;

import java.util.*;

public class OnlineStockSpan {


    public static void main(String[] args) {

        OnlineStockSpan onlineStockSpan = new OnlineStockSpan();
        int[] arr = {100, 80, 60, 70, 60, 75, 85};
        for (int i : arr) {
            System.out.println(onlineStockSpan.next(i));
        }
    }

    Stack<List<Integer>> stack = null;
    Integer count = 0;
    Integer lastVal = null;

    public OnlineStockSpan() {
        stack = new Stack<>();
        count = 0;
    }

    public int next(int price) {
        int count = 1;
        while (!stack.isEmpty() && stack.peek().get(0) <= price) {
            List<Integer> peek = stack.peek();
            count += peek.get(1);
            stack.pop();
        }
        stack.push(Arrays.asList(price, count));
        return count;
    }
}
