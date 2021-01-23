package com.denofprogramming.leetcode.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvaluateRPNTest {

    @Test
    void solution() {
        String[] s = new String [] {"2", "1", "+", "3", "*"};
        EvaluateRPN e = new EvaluateRPN();
        assertEquals(9, e.solution(s));
    }
}