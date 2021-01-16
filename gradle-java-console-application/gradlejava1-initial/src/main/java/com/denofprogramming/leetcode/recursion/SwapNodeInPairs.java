package com.denofprogramming.leetcode.recursion;

public class SwapNodeInPairs {
    /**
     * https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-recursion/1680/
     */

    static class Node {
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }

    static class LinkedList {
        Node head;

        Node getHead() {
            return head;
        }

        LinkedList(int ... values) {
            Node c = null;
            for (int i : values) {
                Node n = new Node(i);
                if (head == null) {
                    head = n;
                } else {
                    c.next = n;
                }
                c = n;
            }
        }

        @Override
        public String toString() {
            Node c = head;
            StringBuilder sb = new StringBuilder();
            while (c != null) {
                sb.append(c.value + " ");
                c = c.next;
            }
            return sb.toString();
        }

    }

    public static String toString(Node c) {
        StringBuilder sb = new StringBuilder();
        while (c != null) {
            sb.append(c.value + " ");
            c = c.next;
        }
        return sb.toString();
    }

    static Node solution(Node head) {

        Node ret;
        ret = swap(head);
        return ret;
    }

    private static Node swap(Node node) {
        if (node == null || node.next == null) {
            return node;
        } else {
            Node next = node.next;
            Node nextNext = next.next;
            next.next = node;
            node.next = swap(nextNext);
            return next;
        }
    }


}
