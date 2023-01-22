package binaryTree;


public class MaxPathSum {
    static int maxValue = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        max(root);
        return maxValue;
    }

    public static int max(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftMax = Math.max(max(node.left),0), rightMax = Math.max(max(node.right),0);
        int maxPassingThroughThisNode = leftMax + rightMax + node.val;
        maxValue = Math.max(maxValue, maxPassingThroughThisNode);
        return node.val + Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
//        TreeNode node = new TreeNode(-10);
//        node.left = new TreeNode(9);
//        node.right = new TreeNode(20);
//        node.right.left = new TreeNode(15);
//        node.right.right = new TreeNode(7);
//        System.out.println(maxPathSum(node));
        System.out.println(maxPathSum(TreeNode.createTree(new Integer[]{2, -1})));
    }
}
