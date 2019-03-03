package stack;

import bst.BSTUtils;
import bst.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TraverseBST {

    public static void solution(TreeNode node) {
        List<Integer> result = new ArrayList();
        Stack<TreeNode> stack = new Stack();

        if (node != null) {
            stack.push(node);
            addLeft(stack, node.left);

            while (stack.empty() == false) {
                TreeNode t = stack.pop();
                result.add(t.val);
                addLeft(stack, t.right);
            }
        }

        System.out.println("Tree traverse solution 1: " + result.toString());
    }

    private static void addLeft(Stack stack, TreeNode node) {
        while (node != null && node.val != -1) {
            stack.push(node);
            node = node.left;
        }
    }

    public static void solution2(TreeNode node) {
        List<Integer> result = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = node;

        while ((curr != null && curr.val != -1) || !stack.isEmpty()) {

            while (curr != null && curr.val != -1) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }

        System.out.println("Tree traverse solution 2: " + result.toString());
    }

    public static void main(String[] argv) {

//        int[] t = {5,2,6,1};
        int[] t = {7,2,6,1,8,3,9,5,11};
        TreeNode root = BSTUtils.buildTree(t);
        System.out.println("tree: " ); BSTUtils.print(root);
        solution2(root);
        solution(root);

    }

}
