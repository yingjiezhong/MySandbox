package com.denofprogramming.algo.dp;

public class LongesetCommonSubsequence {

    public static int lcs(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int[][] t = new int[s2.length+1][s1.length+1];

        // s1: column - j
        // s2: row - i

        // init the row 0 and column 0
        for (int i = 0; i<=s2.length; i++) {
            t[i][0] = 0;
        }
        for (int j = 0; j<=s1.length; j++) {
            t[0][j] = 0;
        }

        for (int i=0; i<s2.length; i++) {
            for (int j=0; j<s1.length; j++) {
                if (s2[i] == s1[j]) {
                    t[i+1][j+1] = t[i][j] + 1;
                } else {
                    t[i+1][j+1] = Math.max(t[i][j+1], t[i+1][j]);
                }
            }
        }

        return t[s2.length][s1.length];
    }


}
