package com.example.datastructure.algoexpert.problem.graph.array;

import java.util.Arrays;

public class MinReward {

//    public static int minRewards(int[] scores) {
//        if (scores.length == 1)
//            return 1;
//        int ans = 0;
//        int[] marks = new int[scores.length];
//        marks[0] = 1;
//        for (int i = 1; i < scores.length; i++) {
//            marks[i] = 1;
//            if (scores[i - 1] < scores[i]) {
//                marks[i] = marks[i - 1] + 1;
//            } else {
//                int j = i;
//                while (j > 0 && scores[j - 1] > scores[j]) {
//                    marks[j - 1] = Math.max(marks[j] + 1, marks[j - 1]);
//                    j--;
//                }
//            }
//        }
//        for (int mark : marks) {
//            ans += mark;
//        }
//        return ans;
//    }

//    public static int minRewards(int[] scores) {
//        if (scores.length == 0)
//            return 0;
//        int totalRewards = 0;
//        int[] reward = new int[scores.length];
//        reward[0] = 1;
//        reward[scores.length - 1] = 1;
//        for (int i = 1; i < scores.length; i++) {
//            reward[i] = 1;
//            if (scores[i - 1] < scores[i]) {
//                reward[i] = reward[i - 1] + 1;
//            }
//        }
//
//        for (int i = scores.length - 2; i >= 0; i--) {
//            if (scores[i] > scores[i + 1]) {
//                reward[i] = Math.max(reward[i + 1] + 1, reward[i]);
//            }
//        }
//
//        System.out.println(Arrays.toString(reward));
//        for (int i : reward) {
//            totalRewards += i;
//        }
//        return totalRewards;
//    }


    public static int minRewards(int[] scores) {
        if (scores.length == 0)
            return 0;
        else if (scores.length < 2)
            return 1;
        int[] rewards = new int[scores.length];
        rewards[0] = 1;
        rewards[scores.length - 1] = 1;
        int i = 1;
        while (i < scores.length) {
            rewards[i] = 1;
            if (scores[i - 1] < scores[i]) {
                rewards[i] = rewards[i - 1] + 1;
            } else {
                if (i != scores.length - 1 && scores[i - 1] > scores[i]) {
                    if (scores[i] > scores[i + 1]){
                        i++;
                        continue;
                    }
                }
                int j = i;
                while (j > 0 && scores[j - 1] > scores[j]) {
                    rewards[j - 1] = Math.max(rewards[j - 1], rewards[j] + 1);
                    j--;
                }
            }
            i++;
        }
        int totalReward = 0;
        for (int j : rewards) {
            totalReward += j;
        }
        return totalReward;
    }
}


