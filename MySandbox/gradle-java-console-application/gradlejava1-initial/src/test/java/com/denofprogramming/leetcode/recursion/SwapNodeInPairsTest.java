package com.denofprogramming.leetcode.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwapNodeInPairsTest {

    @Test
    void solution() {
        SwapNodeInPairs.LinkedList list = new SwapNodeInPairs.LinkedList(1, 2, 3, 4, 5, 6);
        SwapNodeInPairs.Node r = SwapNodeInPairs.solution(list.getHead());
        System.out.println(SwapNodeInPairs.toString(r));

        list = new SwapNodeInPairs.LinkedList(1, 2, 3, 4, 5, 6, 7);
        r = SwapNodeInPairs.solution(list.getHead());
        System.out.println(SwapNodeInPairs.toString(r));
    }
}