package bst;

public class RangeSumOfBST {
    public static int solution(TreeNode node, int L, int R) {
        int sum = 0;
        int left;
        int right;

        if (node.val == -1) {
            return 0;
        } else {
            if (node.val >= L && node.val <= R) {
                sum = node.val;
            }
        }
        left = solution(node.left, L, R);
        right = solution(node.right, L, R);
        sum += left + right;

        return sum;
    }


    public static void main(String[] argv) {

        int[] t = {10,5,15,3,7,-1,18};
        TreeNode root = BSTUtils.convertToTree(t);
        System.out.println("Sum: " + solution(root, 7, 15));

        t = new int[]{10, 5, 15, 3, 7, 13, 18, 1, -1, 6};
        root = BSTUtils.convertToTree(t);
        System.out.println("Sum: " + solution(root, 6, 10));
    }
}
