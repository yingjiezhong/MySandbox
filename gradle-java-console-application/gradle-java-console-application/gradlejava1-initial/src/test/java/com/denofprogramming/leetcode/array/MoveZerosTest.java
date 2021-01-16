package com.denofprogramming.leetcode.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveZerosTest {

    @Test
    void solution() {
        int[] arr1 = {0, 1, 0, 3, 12};
        int[] arr2 = {1, 3, 12, 0, 0};
        new MoveZeros().solution(arr1);
        assertArrayEquals(arr2, arr1);
    }
}