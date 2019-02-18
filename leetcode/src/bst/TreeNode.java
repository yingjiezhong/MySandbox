package bst;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        val = x;
        left = new TreeNode();
        right = new TreeNode();
    }
    private TreeNode() {
        val = -1;
    }

    public void setValue(int i) {
        if (i != -1) {
            val = i;
            left = new TreeNode();
            right = new TreeNode();
        }
    }
}
