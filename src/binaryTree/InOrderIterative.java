package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderIterative {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                TreeNode leftNode = node.left;
                node.left = null;
                if (node.right != null) {
                    stack.push(node.right);
                    node.right = null;
                }
                stack.push(node);
                stack.push(leftNode);
            } else {
                list.add(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                    node.right = null;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        System.out.println(inorderTraversal(treeNode));
    }
}
