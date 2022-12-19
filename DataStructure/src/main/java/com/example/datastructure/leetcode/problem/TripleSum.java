package com.example.datastructure.leetcode.problem;

import java.util.*;
import java.util.stream.Collectors;

public class TripleSum {


    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0, 0};
        Arrays.sort(arr);
        List<List<Integer>> x = threeSum(arr);
        System.out.println(x);
        List<Integer> collect = x.stream().map(a -> a.get(0) + a.get(1) + a.get(2)).collect(Collectors.toList());
        System.out.println(collect);


    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> solution = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i != 0 && nums[i - 1] == nums[i])
                continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    solution.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                }
            }
        }
        return solution;

    }

    public static List<List<Integer>> threeSumUsedBinarySearchAndSet(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> solution = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int thirdNumber = -nums[i] - nums[j];
                int i1 = Arrays.binarySearch(nums, j + 1, nums.length, thirdNumber);
                if (i1 > 0) {
                    List<Integer> integers = Arrays.asList(nums[i], nums[j], nums[i1]);
                    integers.sort(Integer::compareTo);
                    solution.add(integers);
                }
            }
        }
        return new ArrayList<>(solution);
    }

    public static List<List<Integer>> bruteForceThreeNumberSum(int[] nums) {
        Set<List<Integer>> sol = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    List<Integer> sum = new ArrayList<>();
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        sum.add(nums[i]);
                        sum.add(nums[j]);
                        sum.add(nums[k]);
                        sum.sort(Integer::compareTo);
                        sol.add(sum);

                    }
                }
            }
        }
        return new ArrayList<>(sol);
    }
}
