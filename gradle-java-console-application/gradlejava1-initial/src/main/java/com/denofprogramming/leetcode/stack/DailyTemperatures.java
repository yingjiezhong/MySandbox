package com.denofprogramming.leetcode.stack;

import java.util.Arrays;

/**
 * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
 *
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 *
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 *
 */
public class DailyTemperatures {

    public int[] solution(int[] T) {
        int[] ret = new int[T.length];
        Arrays.fill(ret, -1);

        // start with index i, move to the end
        for (int i=0; i<T.length; i++) {
            if (ret[i] == -1) {
                int k = i;
                // for element i, find all elements that is larger than previous, and fill in the ret array
                for (int j = i + 1; j < T.length; j++) {
                    if (T[j] > T[k]) {
                        ret[k] = j - k;
                        k = j;
                    }
                }
                // set the max to 0
                if (ret[k] != 0) {
                    ret[k] = 0;
                }
            }
        }

        return ret;
    }
}
