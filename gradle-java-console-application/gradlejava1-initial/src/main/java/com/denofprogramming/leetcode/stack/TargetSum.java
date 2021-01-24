package com.denofprogramming.leetcode.stack;

/**
 *You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 *
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 *
 * Example 1:
 *
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 */
public class TargetSum {

    int count = 0;
    public int bruteForceSolution(int[] list, int t) {

        count = 0;
        calculate(list, 0, 0, t);
        return count;
    }

    private void calculate(int[] list, int i, int s, int t) {
        if (i == list.length - 1) {
            if (t == s + list[i]) {
                count++;
            }
            if (t == s - list[i]) {
                count++;
            }
        } else {
            calculate(list, i + 1, s+list[i], t);
            calculate(list, i + 1, s-list[i], t);
        }

    }

}
