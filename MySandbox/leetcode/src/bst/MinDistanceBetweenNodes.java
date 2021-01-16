package bst;

public class MinDistanceBetweenNodes {
    private static int solution(TreeNode n) {
        return 0;
    }

    public static void main(String[] argv) {
        int[] t = {4, 2, 6, 1, 3, -1, -1};
        TreeNode root = BSTUtils.convertToTree(t);
        System.out.println("longest:" + solution(root));
    }

}
