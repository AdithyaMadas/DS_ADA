package dailyChallenge;

import binaryTree.TreeNode;

public class IsCompleteTree {
    public static boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right != null) {
            return false;
        }
        return isCompleteTree(root.left) && isCompleteTree(root.right);
    }

    public static void main(String[] args) {
        System.out.println(isCompleteTree(TreeNode.createTree(new Integer[]{1, 2, 3, 4, 5, 6})));
        System.out.println(isCompleteTree(TreeNode.createTree(new Integer[]{1, 2, 3, 4, 5, null, 7})));
    }
}
