package com.denofprogramming.leetcode.tree;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * *
 * Example 1:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 *
 * Example 2:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 */
public class LowestCommonAncestor {

    private Node lca;
    /**
     * Algorithm
     *
     * Start traversing the tree from the root node.
     * If the current node itself is one of p or q, we would mark a variable mid as True and continue the search for the other node in the left and right branches.
     * If either of the left or the right branch returns True, this means one of the two nodes was found below.
     * If at any point in the traversal, any two of the three flags left, right or mid become True, this means we have found the lowest common ancestor for the nodes p and q.
     * Let us look at a sample tree and we search for the lowest common ancestor of two nodes 9 and 11 in the tree.
     */

    Node solution1(Node r, int p, int q) {

        solution(r, p, q);
        return lca;
    }

    boolean solution(Node n, int p, int q) {
        int mid, left, right;
        if (n == null) return false;
        left = solution(n.left, p, q) ? 1 : 0;
        right = solution(n.right, p, q) ? 1 : 0;
        mid = (n.value == p || n.value == q) ? 1 :0;
        if (left + right + mid >=2) {
            lca = n;
        }

        return (left + right + mid > 0);
    }
}
