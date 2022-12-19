package com.example.datastructure.array.problem.solution;

public class MajoritySumProblem {

    public static void main(String[] args) {

    }

    private static int majorityElement(int[] arr) {
        int size = arr.length;
        if (size == 0)
            return -1;
        int curNum = arr[0];
        int count = 1;
        for (int i = 1; i < size; i++) {
            if (curNum != arr[i]) {
                count--;
                if (count <= 0) {
                    count = 1;
                    curNum = arr[i];
                }
            }
        }
        count = 0;
        for (int i = 0; i < size; i++) {
            if (curNum == arr[i]) {
                count++;
            }
        }
        return (count > size / 2) ? curNum : -1;
    }

}
