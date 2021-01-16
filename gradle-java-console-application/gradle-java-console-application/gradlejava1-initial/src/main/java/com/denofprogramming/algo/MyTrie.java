package com.denofprogramming.algo;

import java.util.Collection;
import java.util.HashMap;

public class MyTrie {

    Node root;

    class Node {
        String value;
        HashMap<String, Node> children;

        public Node(String s) {
            value = s;
        }
    }

    MyTrie(Collection<String> strings) {

        for (String s : strings) {
            Node cn = root;
            if (root == null) {
                root = new Node("*");
                cn = root;
            } else {
                int i = 0;
                while (i < s.length()) {
                    char c = s.charAt(i);
                    if (cn.children.containsKey(c)) {
                        cn = cn.children.get(c);
                    } else {
                        Node newNode = new Node(String.valueOf(c));
                        cn.children.put(String.valueOf(c), newNode);
                        cn = newNode;
                    }
                }
            }
        }

    }
}
