package com.denofprogramming.algo.dp;

public class PalindromicSubstring {

    private String string;

    public PalindromicSubstring(String s) {
        this.string = s;
    }

    public static int longest(String s) {
        char[] c = s.toCharArray();
        int[][] t = new int[s.length()][s.length()];
        int max = 1;

        // init the first and second
        for (int i = 0; i < s.length(); i++) {
            t[i][i] = 1;
            if (i < s.length()-1) {
                t[i][i+1] = (c[i] == c[i+1]) ? 1 : 0;
            }
        }

        // fill the rest, diagonally from center to up right corner
        for (int j = 2; j < s.length(); j++) {
            for (int i = 0; i < s.length()-j; i++) {
                t[i][j+i] = (c[i] == c[j+i] && t[i+1][j+i-1] == 1) ? 1 : 0;
                if (t[i][j+i] == 1) {
                    max = Math.max(j+1, max);
                }
            }
        }

        // cannot fill in each row
//        for (int i = 0; i < s.length()-2; i++) {
//            for (int j = 2 + i; j < s.length(); j++) {
//                t[i][j] = (c[i] == c[j] && t[i+1][j-1] == 1) ? 1 : 0;
//                if (t[i][j] == 1) {
//                    max = Math.max(j-i+1, max);
//                }
//            }
//        }
        return max;
    }
}
