package com.denofprogramming.leetcode.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DailyTemperaturesTest {

    @Test
    void solution() {
        int[] T = new int[] {73, 74, 75, 71, 69, 72, 76, 73};
        int[] r = new int[] {1, 1, 4, 2, 1, 1, 0, 0};
        DailyTemperatures dt = new DailyTemperatures();
        int[] r1 = dt.solution(T);
        assertArrayEquals(r, r1);
    }
}