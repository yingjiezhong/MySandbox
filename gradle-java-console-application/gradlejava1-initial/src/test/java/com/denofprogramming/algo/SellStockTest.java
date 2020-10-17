package com.denofprogramming.algo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SellStockTest {

    @Test
    void maxProfit() {
        int[] s = {3, 5, 4, 6, 1, 5};
        SellStock ss = new SellStock();
        assertEquals(4, ss.maxProfit(s));

        s = new int[]{1, 6, 4, 6, 1, 5};
        assertEquals(5, ss.maxProfit(s));
    }

}