package com.denofprogramming.algo;

import org.junit.jupiter.api.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class MyLinkedListTest {

    @BeforeEach
    void init() {
        System.out.println("@BeforeEach - executes before each test method in this class");
    }

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach - executed after each test method.");
    }

    @Test
    void reverse() {
        MyLinkedList list = new MyLinkedList(1, 2, 3, 4, 5, 6, 7, 8);

        list.reverse();

        System.out.println(list.toString());

        assertTrue(true);
    }

    @Test
    void sortedMerge() {
        MyLinkedList l1 = new MyLinkedList(1, 3, 5, 7, 11, 12);
        MyLinkedList l2 = new MyLinkedList(2, 4, 6, 8, 9, 10);

        MyLinkedList.Node n = MyLinkedList.sortedMerge(l1.getHead(), l2.getHead());

        MyLinkedList mergedList = new MyLinkedList(n);

        System.out.println(mergedList.toString());

    }

    @Test
    void merge() {
        MyLinkedList l1 = new MyLinkedList(1, 3, 5, 7, 11, 12);
        MyLinkedList l2 = new MyLinkedList(2, 4, 6, 8, 9, 10);
        System.out.println(l1.toString());
        System.out.println(l2.toString());

        MyLinkedList.Node n = MyLinkedList.merge(l1.getHead(), l2.getHead());

        MyLinkedList mergedList = new MyLinkedList(n);

        System.out.println(mergedList.toString());
    }

    @Test
    void merge2() {
        MyLinkedList l1 = new MyLinkedList(1, 3, 5, 7, 11, 12);
        MyLinkedList l2 = new MyLinkedList(2, 4, 6, 8, 9, 10);
        System.out.println(l1.toString());
        System.out.println(l2.toString());

        MyLinkedList.Node n = MyLinkedList.merge2(l1.getHead(), l2.getHead());

        MyLinkedList mergedList = new MyLinkedList(n);

        System.out.println(mergedList.toString());
    }
}