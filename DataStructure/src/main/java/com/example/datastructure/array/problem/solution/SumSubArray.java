package com.example.datastructure.array.problem.solution;

import java.util.ArrayList;
import java.util.Arrays;

public class SumSubArray {

    public static void main(String[] args) {
        int[] arr = Arrays.stream(
                "142 112 54 69 148 45 63 158 38 60 124 142 130 179 117 36 191 43 89 107 41 143 65 49 47 6 91 130 171 151 7 102 194 149 30 24 85 155 157 41 167 177 132 109 145 40 27 124 138 139 119 83 130 142 34 116 40 59 105 131 178 107 74 187 22 146 125 73 71 30 178 174 98 113"
                        .split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> integers = subarraySum(arr, arr.length, 665);
        System.out.println(integers);
    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> objects = new ArrayList<>();
        int i = 0;
        int j = 0;
        int sum = 0;
        while (j < n) {
            sum += arr[i];
            if (sum == s) {
                objects.addAll(Arrays.asList(j + 1, i + 1));
                return objects;
            } else if (sum < s) {
                i++;
            } else {
                j++;
                sum = 0;
                i = j;
            }

            if (i == n) {
                break;
            }
        }
        objects.add(-1);
        return objects;
    }
}
