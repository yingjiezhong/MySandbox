package com.denofprogramming.leetcode.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecodeStringTest {

    @Test
    void solution() {
        String s = "3[a]2[bc]";
        DecodeString ds = new DecodeString();
        assertEquals("aaabcbc", ds.solution1(s));

        s = "3[a2[c]]";
        assertEquals("accaccacc", ds.solution1(s));

        s = "2[abc]3[cd]ef";
        assertEquals("abcabccdcdcdef", ds.solution1(s));

        s = "abc3[cd]xyz";
        assertEquals("abccdcdcdxyz", ds.solution1(s));
    }
}