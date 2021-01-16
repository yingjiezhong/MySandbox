package com.denofprogramming.algo.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestIncreasingSubsquenceTest {

    @Test
    void longest() {
        int[] a = {1, 5, 3, 7, 6, 8, 9, 2};
        int max = LongestIncreasingSubsquence.longest(a);
        assertEquals(5, max);
    }
}