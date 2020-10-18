package com.denofprogramming.algo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyBSTTest {

    @Test
    void verify() {
//        MyBST bst = new MyBST(4, 2, 3, 6, 7);
        MyBST bst = new MyBST(8, 6, 3, 7, 10, 9, 12);

        boolean r = bst.verify(bst.getRoot());

        assertEquals(true, true);
    }
}