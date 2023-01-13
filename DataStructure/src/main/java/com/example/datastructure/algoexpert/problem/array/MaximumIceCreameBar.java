package com.example.datastructure.algoexpert.problem.array;

import java.util.*;

// 1833. Maximum Ice Cream Bars
public class MaximumIceCreameBar {

    public static int maxIceCream(int[] costs, int coins) {
        int max = 0;
        for (int cost : costs) {
            max = Math.max(max, cost);
        }
        int[] costOfIceCream = new int[max + 1];
        for (int cost : costs) {
            costOfIceCream[cost]++;
        }
        int buy = 0;
        for (int i = 1; i <= max; i++) {
            if (costOfIceCream[i] == 0 || coins < i)
                continue;
            int canBuy = Math.min(costOfIceCream[i], coins / i);
            buy += canBuy;
            coins -= (i * canBuy);
        }
        return buy;
    }
}
