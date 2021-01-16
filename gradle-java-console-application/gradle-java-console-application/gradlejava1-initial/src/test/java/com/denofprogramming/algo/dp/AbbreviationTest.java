package com.denofprogramming.algo.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbbreviationTest {

    @Test
    void subsequence() {
        boolean r = Abbreviation.subsequence("ADE", "ABDE");
        assertEquals(true, r);

        r = Abbreviation.subsequence("ADEF", "ABDE");
        assertEquals(false, r);
    }

    @Test
    void abbreviation() {
        String r = Abbreviation.abbreviation("daBcd", "ABC");
        assertEquals("yes", r);

        r = Abbreviation.abbreviation("sYOCa", "YOCN");
        assertEquals("no", r);
    }
}