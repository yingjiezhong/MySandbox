package bst;

public class nthLargestNode {

    static private int current = 0;

    public static void solution(TreeNode node, int n) {
        BSTUtils.traverse(node, true);
        System.out.println();
        nthNode(node, n);
    }

    private static void nthNode(TreeNode node, int n) {
        if (node == null || node.val == -1) {
            return;
        }
        nthNode(node.right, n);
        current++;
        if (current == n) {
            System.out.println("found " + n + "th largest: " + node.val);
            return;
        }
        if (current > n)
            return;
        nthNode(node.left, n);
    }


    public static void main(String[] argv) {

        int[] t = {5,2,6,1,9,7,4,11,8};
        TreeNode root = BSTUtils.buildTree(t);
        System.out.println("tree: ");
        solution(root, 2);
        current = 0;
        solution(root, 3);
        current = 0;
        solution(root, 6);
    }

}
