package bst;

import java.util.ArrayList;
import java.util.List;

public class BSTUtils {

    static public TreeNode convertToTree(int[] t) {
        int level = 0;
        int i = 0;
        TreeNode root = new TreeNode(t[i++]);
        List<TreeNode> list = new ArrayList();
        list.add(root.left);
        list.add(root.right);

        while (i < t.length) {
//            System.out.println("level: " + level++);
            List<TreeNode> nextList = new ArrayList();
            for (TreeNode n : list) {
                n.setValue(t[i++]);
                nextList.add(n.left);
                nextList.add(n.right);
                if (i >= t.length) break;
            }
            list = nextList;
        }

        return root;
    }

    public static TreeNode buildTree(int[] t) {

        TreeNode root = null;

        for (int i : t) {
            if (root == null) {
                root = new TreeNode(i);
            } else {
                addNode(root, i);
            }
        }

        return root;
    }

    private static void addNode(TreeNode node, int i) {
        if (node.val == -1) {
            node.setValue(i);
            return;
        }
        if (i < node.val) {
            addNode(node.left, i);
        } else {
            addNode(node.right, i);
        }
    }

    public static void traverse(TreeNode node, boolean reverse) {
        if (node == null || node.val == -1)
            return;
        if (reverse) {
            traverse(node.right, reverse);
            System.out.print(node.val + " ");
            traverse(node.left, reverse);
        } else {
            traverse(node.left, reverse);
            System.out.print(node.val + " ");
            traverse(node.right, reverse);
        }
    }

    public static void print(TreeNode node) {

        List<TreeNode> list = new ArrayList();
        List<TreeNode> nextList = new ArrayList();
        int level = 4;

        list.add(node);

        while (list.size() > 0) {

            for (int i = 0; i < level; i++) {
                System.out.print("  ");
            }

            for (TreeNode n : list) {
                System.out.print(n.val);
                System.out.print("  ");

                if (n.left != null && n.left.val != -1) {
                    nextList.add(n.left);
                }
                if (n.right != null && n.right.val != -1) {
                    nextList.add(n.right);
                }
            }
            System.out.println();

            list.clear();
            list.addAll(nextList);
            nextList.clear();
            level--;
        }


    }
}
