package com.denofprogramming.leetcode.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseStringTest {

    @Test
    void solution() {
        String str = "This is a beautiful day";
        char[] chars = str.toCharArray();
        ReverseString.solution(chars);
        System.out.println(chars);

    }
}