package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class MorrisInOrderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
        TreeNode cur = root;
        List<Integer> res = new ArrayList<>();
        while (cur != null) {
            if (cur.left == null) {
                res.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(inorderTraversal(TreeNode.createTree(new Integer[]{1, 2, 3, 4, 5, 6, 7})));
    }
}
