package com.denofprogramming.algo;

public class MyLinkedList {

    private Node head;

    private Object lock = new Object();

    static class Node {
        int v;
        Node next;

        public Node(int v) {
            this.v = v;
        }
    }

    public MyLinkedList(Node head) {
        this.head = head;
    }

    public MyLinkedList(int ... vs) {
        head = null;
        Node c = new Node(0);
        for (int v : vs) {
            if (head == null) {
                head = new Node(v);
                c = head;
            } else {
                c.next = new Node(v);
                c = c.next;
            }
        }
    }

    public Node getHead() {
        return head;
    }

    public static Node sortedMerge(Node n1, Node n2) {

        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }
        if (n1.v < n2.v) {
            n1.next = sortedMerge(n1.next, n2);
            return n1;
        } else {
            n2.next = sortedMerge(n1, n2.next);
            return n2;
        }
    }


    // merge l2 to l1 and return l1
//    public static MyLinkedList merge(MyLinkedList l1, MyLinkedList l2) {

//        Node n1 = l1.head;
//        Node n2 = l2.head;
//
//
//        while (n2 != null) {
//
//            while (n1 != null) {
//                if (n1.next.v < n2.v) {
//                    n1 = n1.next;
//                } else {
//                    // insert n2 before n1.next
//                    Node temp_n1_next = n1.next;
//                    Node temp_n2_next = n2.next;
//                    n1.next = n2;
//
//                    n2 = temp_n2_next;
//                    n1
//                }
//        }
//
//
//    }

    public void reverse() {

        Node c = head;
        Node p = null;
        Node n = c.next;
        Node nn = null;

        while (c != null) {

            // mutate
            if (n!= null) {
                nn = n.next;
                n.next = c;
            }
            c.next = p;

            // set for next round
            p = c;
            c = n;
            n = nn;
        }
        head = p;

    }

    @Override
    public String toString() {
        Node cc = head;
        StringBuilder sb = new StringBuilder();

        while (cc != null) {
            sb.append(cc.v).append(" ");
            cc = cc.next;
        }

        return sb.toString();

    }

    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList(1, 2, 3, 4, 5, 6, 7, 8);
        System.out.println(list);

        list.reverse();
        System.out.println(list);
    }
}
