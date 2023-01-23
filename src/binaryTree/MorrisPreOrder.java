package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class MorrisPreOrder {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        while (root != null) {
            list.add(root.val);
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode prev = root.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = root.right;
                root = root.left;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(preorderTraversal(TreeNode.createTree(new Integer[]{1, 2, 3, 4, 5, 6, 7})));
    }
}
