package com.denofprogramming.algo;

import java.util.*;

public class MyBST {

    private Node root;
    private int size;

    public enum Order {
        PREORDER,
        INORDER,
        POSTORDER,
        BREADTHFIRST,
        DEPTHFIRST
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

    public int nthLargest(int n) {
        Count cur = new Count();
        nthLargest(root, n, cur);
        return 0;
    }

    public class Count {
        int c = 0;
    }

    private void nthLargest(Node node, int n, Count cur) {

        if (node == null || cur.c >= n) {
            return;
        }

        nthLargest(node.right, n, cur);

        cur.c++;

        if (cur.c == n) {
            System.out.println("nth largest is " + node.value);
            return;
        }

        nthLargest(node.left, n, cur);

    }

    public int height() {

        int h = -1;

        h = height(root, h);

        return h;

    }

    private int height(Node n, int h) {

        if (n == null) {
            return h;
        }

        h++;

        h = Math.max(height(n.left, h), height(n.right, h));

        return h;
    }

    public Node getRoot() {
        return root;
    }

    // verify a node and all children are BST
    public boolean verify(Node n) {
        Integer min = Integer.MIN_VALUE;
        Integer max = Integer.MAX_VALUE;
        return boundaryCheck(n, min, max);
    }

    private boolean boundaryCheck(Node n, Integer min, Integer max) {

        if (n == null) {
            return true;
        }

        System.out.println(n.value + " | " + min + " | " + max);

        if (n.value <= min || n.value >= max) {
            return false;
        }

        // left child less than parent's value
        // right child is larger than parent's
        return boundaryCheck(n.left, min, n.value) && boundaryCheck(n.right, n.value, max);
    }


    public void addNode(int value) {
        addNode(root, value);
    }

    public void replaceNode(int from, int to) {
        root = replaceNode(root, from, to);
    }

    private Node replaceNode(Node node, int from, int to) {

        if (node == null) {
            return null;
        }

        if (from < node.value) {
            node.left = replaceNode(node.left, from, to);
        } else if (from > node.value) {
            node.right = replaceNode(node.right, from, to);
        } else {
            System.out.println("replaced value from: " + node.value + " to: " + to);
            node.value = to;
        }
        return node;
    }

    public void deleteNode(int value) {
        root = deleteNode(root, value);
    }

    private Node deleteNode(Node node, int value) {

        if (node == null) {
            return null;
        }

        if (value < node.value) {
            node.left = deleteNode(node.left, value);
        } else if (value > node.value) {
            node.right = deleteNode(node.right, value);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                // min value does not have left child
                node.value = minValue(node.right);

                // why need it - the min value is replaced, now need to delete it
                node.right = deleteNode(node.right, node.value);

            }
        }

        return node;

    }

    private int minValue(Node node) {
        int v = node.value;
        while (node.left != null) {
            v = node.value;
            node = node.left;
        }
        return v;
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


    public ArrayList<Integer> traverse(Order order) {
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
            case BREADTHFIRST:
                breadthFirst(root, list);
                break;
            case DEPTHFIRST: //no equal to postorder. Root first, and first child, and so on
                depthFirst(root, list);
                break;
        }
        return list;
    }

    private void depthFirst(Node root, ArrayList<Integer> list) {
        Stack<Node> stack = new Stack<>();

        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {
            Node n = stack.pop();
            list.add(n.value);

            // push right first, so the order will be from left to right
            if (n.right != null) {
                stack.push(n.right);
            }

            if (n.left != null) {
                stack.push(n.left);
            }

        }
    }

    private void breadthFirst(Node root, ArrayList<Integer> list) {
        Queue<Node> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root);
        }

        while (queue.peek() != null) {
            Node n = queue.remove();
            list.add(n.value);
            if (n.left != null) {
                queue.add(n.left);
            }
            if (n.right != null) {
                queue.add(n.right);
            }
        }
    }

    /**
     * preOrder is used for copying tree
     * @param node
     * @param list
     */
    private void preOrder(Node node, List<Integer> list) {
        if (node != null) {
            list.add(node.value);
            preOrder(node.left, list);
            preOrder(node.right, list);
        }
    }

    /**
     * inOrder is used for sorting
     * @param node
     * @param list
     */
    private void inOrder(Node node, List<Integer> list) {
        if (node != null) {
            inOrder(node.left, list);
            list.add(node.value);
            inOrder(node.right, list);
        }
    }

    /**
     * postOrder is used for deleting tree
     * @param node
     * @param list
     */
    private void postOrder(Node node, List<Integer> list) {
        if (node != null) {
            postOrder(node.left, list);
            postOrder(node.right, list);
            list.add(node.value);
        }
    }


    public static void main (String[] args) {
        MyBST bst = new MyBST(4, 2, 3, 6, 7);

        List<Integer> list = bst.traverse(Order.INORDER);
        System.out.println("inorder: " + list);

        list.clear();
        list = bst.traverse(Order.PREORDER);
        System.out.println("preorder: " + list);

        list.clear();
        list = bst.traverse(Order.BREADTHFIRST);
        System.out.println("breadthFirst: " + list);

        list.clear();
        list = bst.traverse(Order.DEPTHFIRST);
        System.out.println("depthFirst: " + list);

        // add nodes
        bst.addNode(1);
        bst.addNode(5);
        list.clear();
        list = bst.traverse(Order.INORDER);
        System.out.println("inorder: " + list);

        list.clear();
        list = bst.traverse(Order.PREORDER);
        System.out.println("preorder: " + list);

        list.clear();
        list = bst.traverse(Order.BREADTHFIRST);
        System.out.println("breadthFirst: " + list);

        list.clear();
        list = bst.traverse(Order.DEPTHFIRST);
        System.out.println("depthFirst: " + list);


        bst.deleteNode(0);

        // delete nodes
        System.out.println("----- delete nodes: 1 and 5");
        bst.deleteNode(1);
        bst.deleteNode(5);
        list.clear();
        list = bst.traverse(Order.INORDER);
        System.out.println("inorder: " + list);

        list.clear();
        list = bst.traverse(Order.PREORDER);
        System.out.println("preorder: " + list);

        list.clear();
        list = bst.traverse(Order.BREADTHFIRST);
        System.out.println("breadthFirst: " + list);

        list.clear();
        list = bst.traverse(Order.DEPTHFIRST);
        System.out.println("depthFirst: " + list);

        // delete nodes
        System.out.println("----- delete nodes: " + 4);
        bst.deleteNode(4);
        list.clear();
        list = bst.traverse(Order.INORDER);
        System.out.println("inorder: " + list);

        list.clear();
        list = bst.traverse(Order.PREORDER);
        System.out.println("preorder: " + list);

        list.clear();
        list = bst.traverse(Order.BREADTHFIRST);
        System.out.println("breadthFirst: " + list);

        list.clear();
        list = bst.traverse(Order.DEPTHFIRST);
        System.out.println("depthFirst: " + list);

    }

}
