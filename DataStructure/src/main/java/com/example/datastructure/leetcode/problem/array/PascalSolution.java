package com.example.datastructure.leetcode.problem.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalSolution {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        int start = 1;
        while (start <= numRows) {
            if (start == 1) {
                ans.add(Arrays.asList(1));
            } else if (start == 2) {
                ans.add(Arrays.asList(1, 1));
            } else {
                List<Integer> previous = ans.get(start - 2);
                List<Integer> current = new ArrayList<>(previous.size() + 1);
                for (int i = 0; i <= previous.size(); i++) {
                    if (i == 0 || i == previous.size()) {
                        current.add(1);
                        continue;
                    }
                    int val = previous.get(i) + previous.get(i - 1);
                    current.add(val);
                }
                ans.add(current);
            }
            start++;
        }
        return ans;
    }
}
