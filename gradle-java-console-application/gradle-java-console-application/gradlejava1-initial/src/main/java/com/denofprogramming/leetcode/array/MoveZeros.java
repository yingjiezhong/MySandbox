package com.denofprogramming.leetcode.array;

public class MoveZeros {

    /**
     * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     *
     * Example:
     *
     * Input: [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     * Note:
     *
     * You must do this in-place without making a copy of the array.
     * Minimize the total number of operations.
     */

    void solution(int[] arr) {

        for (int i=0; i<arr.length; i++) {
            if (arr[i] != 0) {
                continue;
            }

            // arr[i] is zero
            // find j is after i and not zero
            int j = i+1;
            if (j >= arr.length) {
                break;
            }
            while (j < arr.length && arr[j] == 0) {
                j++;
            }

            if (j < arr.length) {
                swap(arr, i, j);
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
