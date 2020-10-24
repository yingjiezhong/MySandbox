package com.denofprogramming.algo.dp;

import org.apache.commons.math3.analysis.function.Max;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxArraySumTest {

    @Test
    void sum() {
//        int[] a = {2, 1, 5, 8, 4, 3, 6};
//        assertEquals(17, MaxArraySum.sum(a));
//        assertEquals(17, MaxArraySum.maxSubsetSum(a));
//
//        int[] a2 = {3, 5, -7, 8, 10};
//        assertEquals(15, MaxArraySum.sum(a2));
//        assertEquals(15, MaxArraySum.maxSubsetSum(a2));
//
//        int[] a3 = {3, 7, 4, 6, 5};
//        assertEquals(13, MaxArraySum.sum(a3));
//        assertEquals(13, MaxArraySum.maxSubsetSum(a3));
//
//        int[] a4 = {-2, 1, 3, -4, 5};
//        assertEquals(8, MaxArraySum.sum(a4));
//        assertEquals(8, MaxArraySum.maxSubsetSum(a4));
//
//        int[] a5 = {-1, -1, -1, -1, -1};
//        assertEquals(-1, MaxArraySum.sum(a5));
//        assertEquals(-1, MaxArraySum.maxSubsetSum(a5));
//
        int[] a6 = {8, 7, 4, 6, 5, 5};
        assertEquals(19, MaxArraySum.sum(a6));
        assertEquals(19, MaxArraySum.maxSubsetSum(a6));

    }

}