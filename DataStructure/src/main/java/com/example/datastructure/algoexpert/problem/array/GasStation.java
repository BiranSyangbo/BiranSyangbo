package com.example.datastructure.algoexpert.problem.array;

public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5, 5, 3};
        int[] costs = {2, 3, 4, 3, 9, 6, 2};
        System.out.println(canCompleteCircuit(gas, costs));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalCost += cost[i];
            totalGas += gas[i];
        }
        if (totalGas < totalCost)
            return -1;
        int remain = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            remain += (gas[i] - cost[i]);
            if (remain < 0) {
                remain = 0;
                start = i + 1;
            }
        }
        return start;
    }
}
