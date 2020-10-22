package com.denofprogramming.algo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyBSTTest {

    @Test
    void verify() {
//        MyBST bst = new MyBST(4, 2, 3, 6, 7);
//        MyBST bst = new MyBST(8, 6, 3, 7, 10, 9, 12);
        MyBST bst = new MyBST(4, 2, 1, 3, 6, 5, 7);
        boolean r = bst.verify(bst.getRoot());

        assertEquals(true, r);

        bst.replaceNode(3, 9);

        r = bst.verify(bst.getRoot());

        assertEquals(false, r);
    }

    @Test
    void height() {
        MyBST bst = new MyBST(4, 2, 1, 3, 6, 5, 7);
        int h = bst.height();
        assertEquals(2, h);

        bst = new MyBST(3, 2, 1, 5, 4, 6, 7);
        h = bst.height();
        assertEquals(3, h);
    }
}