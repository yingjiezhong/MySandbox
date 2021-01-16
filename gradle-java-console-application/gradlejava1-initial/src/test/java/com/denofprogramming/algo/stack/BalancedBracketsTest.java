package com.denofprogramming.algo.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalancedBracketsTest {

    @Test
    void isBalanced() {

        assertEquals("NO", BalancedBrackets.isBalanced("}][}}(}][))]"));
        assertEquals("YES", BalancedBrackets.isBalanced("()[]"));
        assertEquals("NO", BalancedBrackets.isBalanced("(}]}"));
    }
}