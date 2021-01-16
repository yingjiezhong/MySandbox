package com.denofprogramming.leetcode.tree;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PathSumTest {

    @Test
    void solution() {
        MyBST bst = new MyBST(4, 2, 3, 6, 7);
        PathSum ps = new PathSum();

        boolean b = ps.solution(bst.getRoot(), 6);
        Assert.assertEquals(true, b);

        b = ps.solution(bst.getRoot(), 9);
        Assert.assertEquals(true, b);

        b = ps.solution(bst.getRoot(), 10);
        Assert.assertEquals(true, b);

        b = ps.solution(bst.getRoot(), 17);
        Assert.assertEquals(true, b);

        b = ps.solution(bst.getRoot(), 12);
        Assert.assertEquals(false, b);
    }
}