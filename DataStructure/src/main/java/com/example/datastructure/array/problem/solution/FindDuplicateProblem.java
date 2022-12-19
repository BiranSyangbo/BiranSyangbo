package com.example.datastructure.array.problem.solution;

import java.util.ArrayList;
import java.util.Arrays;

public class FindDuplicateProblem {

    public static void main(String[] args) {
        int a[] = Utils.convert("13 9 25 1 1 0 22 13 22 20 3 8 11 25 10 3 15 11 19 20 2 4 25 14 23 14", " ");
        ArrayList<Integer> duplicates = duplicate(a, a.length);
        System.out.println("duplicates = " + duplicates);
    }

    public static ArrayList<Integer> duplicate(int arr[], int n) {
        ArrayList<Integer> duplicateList = new ArrayList<Integer>();

        Arrays.sort(arr);
        int x = -1;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1] && x != arr[i]) {
                duplicateList.add(arr[i]);
                x = arr[i];
            }
        }
        if (duplicateList.isEmpty()) {
            duplicateList.add(-1);
        }
        duplicateList.sort(Integer::compareTo);
        return duplicateList;
    }

    // Take Longer Time
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        ArrayList<Integer> duplicateList = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j] && i != j) {
                    if (!duplicateList.contains((arr[i])))
                        duplicateList.add(arr[i]);
                }
            }
        }
        if (duplicateList.isEmpty())
            duplicateList.add(-1);
        duplicateList.sort(Integer::compareTo);
        return duplicateList;
    }
}

