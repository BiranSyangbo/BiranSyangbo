package com.example.datastructure.array.problem.solution;

// 55. Jump Game
public class CanJump {

    public boolean canJump(int[] nums) {
        int move = 1;
        int i = 0;
        int prev = i;
        while (i < nums.length) {
            int max = 0;
            while (prev < nums[i]) {
                max = Math.max(max, nums[prev]);
                prev++;
            }
            i = prev = max;
            move += max;
        }
        return move >= nums.length;
    }
}
