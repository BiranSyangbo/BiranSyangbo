package com.example.datastructure.array.problem.solution;

import java.util.Arrays;

public class MinimumJump {
    public static void main(String[] args) {
        int[] arr = // {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
                Arrays.stream(
                        "2 3 1 1 2 4 2 0 1 1"
                                .split(" ")).mapToInt(Integer::parseInt).toArray();
        int i = minJumps(arr);
        System.out.println("i = " + i);

    }

    static int test(int[] arr) {
        int position = 0, i = 0, jumps = 0, jumpLocation = 0;

        // Logic Iteration
        for (i = 0; i < arr.length; i++) {
            if (i == arr.length - 1)
                return (jumpLocation >= arr.length - 1) ? jumps : -1;

            position = Math.max(position, i + arr[i]);
            if (i == jumpLocation) {
                jumpLocation = position;
                jumps++;
            }
        }

        // edge cases
        if (arr.length <= 1)
            return 0;
        if (arr[0] == 0)
            return -1;

        return -1;
    }

    static int minJumps(int[] arr) {
        int size = arr.length;
        if (size == 0)
            return -1;

        int position = 1;
        int start = 0;
        int v1 = arr[0]; // 4
        start += v1; // 1
        for (int i = 0; i < size; i++) { // i = 1
            v1 = Math.max(v1, i + arr[i]); // 4 < 1
            if (i == start) { // 1 == 1
                start += v1; // 5
                position++; // 2
            }
            if (start >= size - 1) {
                return position;
            }

        }
        return -1;
    }
}
