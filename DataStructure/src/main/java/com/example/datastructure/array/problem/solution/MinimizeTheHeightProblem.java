package com.example.datastructure.array.problem.solution;

import java.util.Arrays;

public class MinimizeTheHeightProblem {

    public static void main(String[] args) {
        int arr[] =  {1, 5, 8, 10}; //convert("2 6 3 4 7 2 10 3 2 1", " ");
        int minDiff = getMinDiff(arr, arr.length, 2);
        System.out.println("minDiff = " + minDiff);
    }

   static int getMinDiff(int arr[], int n, int k) {
        Arrays.sort(arr);
        int ans = arr[n-1]-arr[0]; // 10-1 = 9
        for(int i=1;i<n;i++)
        {
            int mx = Math.max(arr[i-1]+k,arr[n-1]-k); // 8, 8, 10
            int mn = Math.min(arr[0]+k,arr[i]-k); // 3,3,3

            ans = Math.min(mx-mn,ans);
        }
        return ans;
    }

}
