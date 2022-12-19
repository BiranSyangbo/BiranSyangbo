package com.example.datastructure.leetcode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] sum = {1000000000, 1000000000, 1000000000, 1000000000};
        int target = -294967296;
        List<List<Integer>> lists = fourSum(sum, target);
        System.out.println(lists);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int l = nums.length - 1; l > i; l--) {
                if ((i != 0 && nums[i] == nums[i - 1]) || (l < nums.length - 1 && nums[l] == nums[l + 1]))
                    continue;
                int j = i + 1;
                int k = l - 1;
                while (j < k) {
                    long sum = ((long)nums[i] + (long) nums[j] + (long) nums[k] + (long) nums[l]);
                    if (sum > target) {
                        k--;
                    } else if (sum < target) {
                        j++;
                    } else {
                        list.add(Arrays.asList(nums[i], nums[j++], nums[k--], nums[l]));
                        while (j < k && nums[j] == nums[j - 1])
                            j++;
                    }
                }
            }
        }
        return list;
    }

}
