package binaryTree;


public class MaxPathSum {
    static int max = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        max(root);
        return max;
    }

    public static int max(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftMax = max(node.left);
        int rightMax = max(node.right);
        max = Math.max(max, leftMax + rightMax + node.val);
        return leftMax + rightMax + node.val;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(-3);
        System.out.println(maxPathSum(node));
    }
}
