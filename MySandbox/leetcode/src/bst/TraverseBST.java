package bst;

public class TraverseBST {

    public static void solution(TreeNode node) {
        BSTUtils.traverse(node, false);
    }


    public static void main(String[] argv) {

        int[] t = {5,2,6,1};
        TreeNode root = BSTUtils.buildTree(t);
        System.out.println("tree: ");
        solution(root);

    }

}
