package com.denofprogramming.algo;

public class MyLinkedList {

    private Node head;

    private Object lock = new Object();

    private static class Node {
        int v;
        Node next;

        public Node(int v) {
            this.v = v;
        }
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
