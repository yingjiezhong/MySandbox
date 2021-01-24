package com.denofprogramming.leetcode.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TargetSumTest {

    @Test
    void bruteForceSolution() {
        int[] list = {1, 1, 1, 1, 1};
        TargetSum ts = new TargetSum();
        assertEquals(5, ts.bruteForceSolution(list, 3));

        list = new int[] {1,0};
        assertEquals(2, ts.bruteForceSolution(list, 1));

    }
}