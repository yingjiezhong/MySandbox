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

    // it works
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

    public static Node merge2(Node l1, Node l2) {
        Node head = new Node(0);

        Node tail = head;

        while (true) {
            if (l1 == null) {
                tail.next = l2;
                break;
            }
            if (l2 == null) {
                tail.next = l1;
                break;
            }

            if (l1.v < l2.v) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;

        }
        return head.next;
    }

    // find which one is smaller and use it as the new head
    public static Node merge(Node l1, Node l2) {

        Node n1, n2, head;
        if ( l1.v < l2.v)
        {
            head = l1;
            n1 = l1;
            n2 = l2;
        } else {
            head = l2;
            n1 = l2;
            n2 = l1;
        }

        while (n1 != null && n2 != null) {
            while (n2 != null) {
                if (n1.next == null || n1.next.v < n2.v) {
                    n1 = n1.next;
                    break;
                } else {
                    // insert n2 before n1.next
                    // cache
                    Node n1_next = n1.next;
                    Node n2_next = n2.next;

                    // mutate
                    n1.next = n2;
                    n2.next = n1_next;

                    n2 = n2_next;
                    n1 = n1.next;
                }
            }


        }

        return head;

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
