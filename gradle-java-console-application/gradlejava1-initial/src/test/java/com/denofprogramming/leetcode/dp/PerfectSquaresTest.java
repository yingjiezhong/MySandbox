package com.denofprogramming.leetcode.dp;

import com.denofprogramming.leetcode.dp.PerfectSquares;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PerfectSquaresTest {

    @Test
    void solution() {
        PerfectSquares ps = new PerfectSquares();
        assertEquals(1, ps.solution(1));
        assertEquals(2, ps.solution(2));
        assertEquals(3, ps.solution(3));
        assertEquals(1, ps.solution(4));
        assertEquals(2, ps.dpSolution(5));
        assertEquals(3, ps.dpSolution(12));
        assertEquals(2, ps.dpSolution(13));
//        assertEquals(3, ps.dpSolution(108));
    }
}