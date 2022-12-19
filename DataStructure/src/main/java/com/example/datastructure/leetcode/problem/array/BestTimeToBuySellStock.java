package com.example.datastructure.leetcode.problem.array;

public class BestTimeToBuySellStock {
    public static void main(String[] args) {
        int[] arr = {7, 2, 5, 1, 3, 6, 4};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] nums) {
        int max = Integer.MAX_VALUE;
        int s = 0;
        for (int num : nums) {
            if (num < max) {
                max = num;
            }
            s = Math.max(s, num - max);
        }
        return s;
    }

//    public static int maxProfit(int[] prices) {
//        int highest;
//        int lowest = 0;
//        int ans  = 0;
//        for (int i = 1; i < prices.length; i++) {
//            if (prices[lowest] > prices[i]) {
//                lowest = i;
//            }
//
//            if (lowest < i && prices[i - 1] < prices[i]) {
//                highest = i;
//                ans = Math.max(ans, prices[highest] - prices[lowest]);
//            }
//
//        }
//        return ans;
//    }
}
