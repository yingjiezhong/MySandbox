package com.denofprogramming.leetcode.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyCircularQueueTest {

    @Test
    void enQueue() {

        MyCircularQueue q = new MyCircularQueue(3);
        assertEquals(true, q.enQueue(1));
        assertEquals(true, q.enQueue(2));
        assertEquals(true, q.enQueue(3));
        assertEquals(false, q.enQueue(4));

        assertEquals(3, q.rear());
        assertEquals(true, q.isFull());
        assertEquals(true, q.deQueue());
        assertEquals(true, q.enQueue(4));
        assertEquals(4, q.rear());
    }
}