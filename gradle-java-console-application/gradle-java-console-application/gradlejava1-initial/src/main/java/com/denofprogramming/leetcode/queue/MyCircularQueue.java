package com.denofprogramming.leetcode.queue;

/**
 * Implementation the MyCircularQueue class:
 *
 * MyCircularQueue(k) Initializes the object with the size of the queue to be k.
 *
 * int Front() Gets the front item from the queue. If the queue is empty, return -1.
 * int Rear() Gets the last item from the queue. If the queue is empty, return -1.
 * boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.
 * boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.
 * boolean isEmpty() Checks whether the circular queue is empty or not.
 * boolean isFull() Checks whether the circular queue is full or not.
 */
public class MyCircularQueue {

    private int[] queue;
    private int capacity;
    private int head, tail;

    public MyCircularQueue(int k) {
        /* allocate k+1 space, don't use index 0 */
        queue = new int[k];
        capacity = k;
        /* starting point can be 1 and 1, but need to check size */
        head = -1;
        tail = -1;
    }

    int front() {
        if (isEmpty()) return -1;
        return queue[head];
    }

    int rear() {
        if (isEmpty()) return -1;
        return queue[tail];
    }

    synchronized boolean enQueue(int value) {
        if (isFull()) {
            return false;
        } else {
            if (isEmpty()) {
                head = tail = 0;
            } else {
                tail = (tail+1) % capacity;
            }
            queue[tail] = value;
            return true;
        }
    }

    synchronized boolean deQueue() {
        if (isEmpty()){
           return false;
        }

        if (head == tail) {
            head = tail = -1;
        } else {
            head = (head + 1) % capacity;
        }
        return true;
    }

    boolean isEmpty() {

        return head == -1;
    }

    boolean isFull() {
        return head == (tail + 1) % capacity;
    }

}
