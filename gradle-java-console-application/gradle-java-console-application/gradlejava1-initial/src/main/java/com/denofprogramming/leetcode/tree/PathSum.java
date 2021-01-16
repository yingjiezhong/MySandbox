package com.denofprogramming.leetcode.tree;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */

public class PathSum {

    class Value {
        int v;

        Value(int v) {
            this.v = v;
        }

        int getV() {return v;}
    }

    boolean solution(Node r, int s) {

        return solution(r, s, new Value(0));
    }

    private boolean solution(Node r, int s, Value value) {

        if (r == null) {
            if (s == value.getV()) {
                return true;
            } else {
                return false;
            }
        }

        return solution(r.left, s, new Value(value.getV()+r.value)) ||
        solution(r.right, s, new Value(value.getV()+r.value));

    }

}
