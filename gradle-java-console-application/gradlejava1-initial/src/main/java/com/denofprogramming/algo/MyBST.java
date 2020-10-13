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

    public void addNode(int value) {
        addNode(root, value);
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
                node.value = minValue(node.right);

                // why need it?
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
