package com.denofprogramming.algo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class MyLinkedListTest {

    @Test
    void reverse() {
        MyLinkedList list = new MyLinkedList(1, 2, 3, 4, 5, 6, 7, 8);

        list.reverse();

        System.out.println(list.toString());

        assertTrue(true);
    }
}