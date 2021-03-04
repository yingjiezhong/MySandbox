package com.denofprogramming.leetcode.dp;

import com.denofprogramming.leetcode.dp.PerfectSquares;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PerfectSquaresTest {

    @Test
    void solution() {
        PerfectSquares ps = new PerfectSquares();
        assertEquals(1, ps.dpSolution(1));
        assertEquals(2, ps.dpSolution(2));
        assertEquals(3, ps.dpSolution(3));
        assertEquals(1, ps.dpSolution(4));
        assertEquals(2, ps.dpSolution(5));
        assertEquals(3, ps.dpSolution(12));
        assertEquals(2, ps.dpSolution(13));
        // it may take too long time to run large number
//        assertEquals(2, ps.dpSolution(68));     //3.3m vs 1 sec
        assertEquals(3, ps.dpSolution(108));    // 1 sec
    }
}