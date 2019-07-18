package heap;

import java.util.LinkedList;
import java.util.List;

public class MaxHeapTree {

    private static Node root;

    public static void main (String argv[]) {
        int input[] = {1, 6, 2, 9, 7, 4, 3, 8, 5};
//        int input[] = {1, 6, 2, 9, 7, 4};

        MaxHeapTree mh = new MaxHeapTree();
        mh.initialize(input);

        System.out.println(mh);

    }

    private static Node initialize(int[] input) {

        for (int i : input){

            if (root == null) {
                root = new Node(i);
                continue;
            }

            Node n = root;
            while (n != null) {
                if (n.value > i) {
                    // when node value is larger, compare with its children
                    if (n.left == null) {
                        n.left = new Node(i);
                        break;
                    }
                    else if (n.right == null) {
                        n.right = new Node(i);
                        break;
                    }
                    else {
                        n = n.left.value < n.right.value ? n.left : n.right;
                    }
                } else {
                    // when the node value is smaller, replace the node value,
                    int temp = n.value;
                    n.value = i;
                    i =  temp;
                }

            }
        }
        return root;

    }

    public String toString() {
        List<Integer> heap = new LinkedList<>();

        List<Node> nodes = new LinkedList<>();
        List<Node> nodes2 = new LinkedList<>();
        nodes2.add(root);

        do {
            nodes.clear();
            nodes.addAll(nodes2);
            nodes2.clear();
            for (Node n : nodes) {
                if (n != null) {
                    heap.add(n.value);
                    nodes2.add(n.left);
                    nodes2.add(n.right);
                }
            }
        } while (nodes2.size() > 0);

        return heap.toString();
    }

    private static class Node {
        Node left;
        Node right;
        int value;

        Node(int v) {
            value = v;
        }
    }

}
