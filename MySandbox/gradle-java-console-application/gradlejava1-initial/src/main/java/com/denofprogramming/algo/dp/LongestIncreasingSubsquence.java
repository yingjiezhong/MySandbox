package com.denofprogramming.algo.dp;

import java.util.Arrays;

public class LongestIncreasingSubsquence {

    public static int longest(int[] s) {
        int max = 0;

        int[] lis = new int[s.length];

        for (int i = 0; i< s.length; i++) {
            lis[i] = 1;
        }

        for (int i = 0; i<s.length; i++) {
            for (int j = 0; j <= i; j++ ) {
                if (s[i] > s[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
            System.out.println(lis[i]);
            max = Math.max(max, lis[i]);
        }
        return max;
    }
}
