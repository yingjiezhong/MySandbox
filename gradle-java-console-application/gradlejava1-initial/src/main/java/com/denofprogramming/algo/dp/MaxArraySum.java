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
    public static int sum(int[] a) {

        int n = a.length;
        int max = 0;
        int[][] t = new int[n][n];

        // fill in the top half of the matrix
        for (int i = 0; i < n; i++) {
            for (int j=i; j < n; j++) {
                if (i == j || j == i+1) {
                    t[i][j] = 0;
                } else if (j == i+2 || j == i+3){
                    t[i][j] = a[i] + a[j];
                } else {
                    t[i][j] = a[j] + Math.max(Math.max(t[i][j-3], t[i][j-2]), a[i]);
                }
                max = Math.max(max, t[i][j]);
            }
        }
        return max;
    }
}
