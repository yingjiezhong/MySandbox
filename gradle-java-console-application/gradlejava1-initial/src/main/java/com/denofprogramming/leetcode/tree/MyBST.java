package com.denofprogramming.leetcode.tree;

import java.util.*;

public class MyBST {

    private Node root;
    private int size;

    public enum Order {
        PREORDER,
        INORDER,
        POSTORDER
    }

    public MyBST(int ... values){

        for (int value : values) {
            if (root == null) {
                root = new Node(value);
                size++;
            } else {
                addNode(root, value);
            }
        }
    }

    public Node getRoot() {
        return root;
    }

    public void addNode(int value) {
        addNode(root, value);
    }

    private Node addNode(Node node, int value) {
        if (node == null) {
            node = new Node(value);
            size++;
        } else if (value < node.value) {
            node.left = addNode(node.left, value);
        } else {
            node.right = addNode(node.right, value);
        }
        return node;
    }

    public ArrayList<Integer> iterativeTraverse(Order order) {
        ArrayList<Integer> list = new ArrayList<>();
        switch (order) {
            case PREORDER:
                preOrder(root, list);
                break;
            case POSTORDER:
                postOrder(root, list);
                break;
            case INORDER:
                inOrder(root, list);
                break;
        }
        return list;
    }

    private void preOrder(Node root, ArrayList<Integer> list) {
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();

        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {
            Node n = stack.peek();
            if (n != null) {
                if (!set.contains(n)) {
                    list.add(n.value);
                    set.add(n);
                }

                Node l = n.left;
                Node r = n.right;
                if (l != null && !set.contains(l)) {
                    stack.push(l);
                    continue;
                }
                if (r != null && !set.contains(r)) {
                    stack.push(r);
                    continue;
                }
                if (set.contains(n)) {
                    stack.pop();
                }
            }
        }
    }

    /**
     * postOrder is used for copying tree
     * @param node
     * @param list
     */
    private void postOrder(Node node, List<Integer> list) {
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();

        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {
            Node n = stack.peek();
            if (n != null) {
                Node l = n.left;
                Node r = n.right;
                if (l != null && !set.contains(l)) {
                    stack.push(l);
                    continue;
                }
                if (r != null && !set.contains(r)) {
                    stack.push(r);
                    continue;
                }
                n = stack.pop();
                list.add(n.value);
                set.add(n);
            }
        }
    }

    /**
     * inOrder is used for deleting tree
     * @param node
     * @param list
     */
    private void inOrder(Node node, List<Integer> list) {
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();

        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {
            Node n = stack.peek();
            if (n != null) {
                Node l = n.left;
                Node r = n.right;
                if (l != null && !set.contains(l)) {
                    stack.push(l);
                    continue;
                }
                if (!set.contains(n)) {
                    list.add(n.value);
                    set.add(n);
                }
                if (r != null && !set.contains(r)) {
                    stack.push(r);
                    continue;
                }
                if (set.contains(n)) {
                    stack.pop();
                }
            }
        }
    }


    public static void main (String[] args) { }

}
