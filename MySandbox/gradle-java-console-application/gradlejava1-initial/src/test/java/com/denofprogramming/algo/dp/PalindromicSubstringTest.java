package com.denofprogramming.algo.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromicSubstringTest {

    @Test
    void longest() {
        int max = PalindromicSubstring.longest("absusbiibe");
        assertEquals(5, max);

        max = PalindromicSubstring.longest("aabbccbbae");
        assertEquals(8, max);
    }
}