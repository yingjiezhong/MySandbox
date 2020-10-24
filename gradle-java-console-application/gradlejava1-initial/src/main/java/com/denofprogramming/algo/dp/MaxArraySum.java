package com.denofprogramming.algo.dp;

public class MaxArraySum {

    /**
     *Given an array of integers, find the subset of non-adjacent elements with the maximum sum. Calculate the sum of that subset.
     *
     * For example, given an array  we have the following possible subsets:
     *
     * Subset      Sum
     * [-2, 3, 5]   6
     * [-2, 3]      1
     * [-2, -4]    -6
     * [-2, 5]      3
     * [1, -4]     -3
     * [1, 5]       6
     * [3, 5]       8
     * Our maximum subset sum is .
     * @param a
     * @return
     */
    public static int sum(int[] arr) {

        int n = arr.length;
        int max = 0;
        int[][] t = new int[n][n];

        // fill in the top half of the matrix
        if (arr.length == 0) {
            return 0;
        } else if (arr.length == 1) {
            return arr[0];
        }else if (arr.length == 2) {
            return Math.max(arr[0], arr[1]);
        } else {

            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    if (i == j || j == i + 1) {
                        t[i][j] = 0;
                    } else if (j == i + 2 || j == i + 3) {
                        t[i][j] = arr[i] + Math.max(0, arr[j]);
                    } else {
                        t[i][j] = Math.max(0, arr[j]) + Math.max(Math.max(t[i][j - 3], t[i][j - 2]), arr[i]);
                    }
                    max = Math.max(max, t[i][j]);
                }
            }
        }

        return max;
    }

    public static int maxSubsetSum(int[] arr) {
        if (arr.length == 0) return 0;
        arr[0] = Math.max(0, arr[0]);
        if (arr.length == 1) return arr[0];
        arr[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++)
            arr[i] = Math.max(arr[i-1], arr[i]+arr[i-2]);
        return arr[arr.length-1];
    }
}
