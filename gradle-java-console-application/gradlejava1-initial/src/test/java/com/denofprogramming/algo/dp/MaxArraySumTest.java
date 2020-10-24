package com.denofprogramming.algo.dp;

import org.apache.commons.math3.analysis.function.Max;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxArraySumTest {

    @Test
    void sum() {
        int[] a = {2, 1, 5, 8, 4, 3, 6};
        assertEquals(17, MaxArraySum.sum(a));

        int[] a2 = {3, 5, -7, 8, 10};
        assertEquals(15, MaxArraySum.sum(a2));

        int[] a3 = {3, 7, 4, 6, 5};
        assertEquals(13, MaxArraySum.sum(a3));
    }

}