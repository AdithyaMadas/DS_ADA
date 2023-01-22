package binaryTree;

import java.util.Arrays;

public class BuildTreeFromInOrderPreOrder {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int indexOfRoot = findIndexOfRoot(inorder, root.val);
        int[] leftPreOrderTree = new int[indexOfRoot];
        int[] leftInOrderTree = new int[indexOfRoot];
        System.arraycopy(preorder, 1, leftPreOrderTree, 0, indexOfRoot);
        System.arraycopy(inorder, 0, leftInOrderTree, 0, indexOfRoot);
        int[] rightPreOrderTree = new int[preorder.length - indexOfRoot - 1];
        int[] rightInOrderTree = new int[preorder.length - indexOfRoot - 1];
        System.arraycopy(preorder, indexOfRoot+1, rightPreOrderTree, 0, preorder.length - indexOfRoot - 1);
        System.arraycopy(inorder, indexOfRoot + 1, rightInOrderTree, 0, preorder.length - indexOfRoot - 1);
        root.left = buildTree(leftPreOrderTree, leftInOrderTree);
        root.right = buildTree(rightPreOrderTree, rightInOrderTree);
        return root;
    }

    private static int findIndexOfRoot(int[] inorder, int val) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode node = buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(node);
    }
}
