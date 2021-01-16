package com.denofprogramming.leetcode.recursion;

public class ReverseString {

    public static void solution(char[] str) {

        helper(0, str);
    }

    private static void helper(int i, char[] str) {

        if (i >= str.length/2) {
            return;
        }
        char t = str[i];
        str[i] = str[str.length - 1 - i];
        str[str.length - 1 - i] = t;
        helper(i+1, str);
    }
}
