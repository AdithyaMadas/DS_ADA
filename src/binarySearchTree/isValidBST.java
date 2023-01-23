package binarySearchTree;

import java.util.Stack;

public class isValidBST {

    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

//    public static boolean isValidBST(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        return findMax(root.left) < root.val && findMin(root.right) > root.val && isValidBST(root.left) && isValidBST(root.right);
//    }
//
//    private static long findMin(TreeNode right) {
//        if(right==null) return Long.MAX_VALUE;
//        while (right.left != null) {
//            right = right.left;
//        }
//        return right.val;
//    }
//
//    private static long findMax(TreeNode left) {
//        if(left==null) return Long.MIN_VALUE;
//        while (left.right != null) {
//            left = left.right;
//        }
//        return left.val;
//    }

    public static void main(String[] args) {
        System.out.println(isValidBST(TreeNode.createTree(new Integer[]{2,1,3})));
    }
}
