package com.denofprogramming.algo.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongesetCommonSubsequenceTest {

    @Test
    void longest() {
//        int max = LongesetCommonSubsequence.longest("AGGTAB", "GXTXAYB");
//        assertEquals(4, max);

        int max = LongesetCommonSubsequence.lcs("AGGTABXYYZXXXYYYZZZ", "GXTXAYBGHBYXBYBYBZXYZ");
        assertEquals(11, max);
    }
}