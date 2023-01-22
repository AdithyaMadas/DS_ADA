package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagTraversal {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int level = 0;
        while (!stack.isEmpty()) {
            Stack<TreeNode> newStack = new Stack<>();
            List<Integer> list = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode poppedNode = stack.pop();
                list.add(poppedNode.val);
                if ((level & 1) == 0) {
                    if (poppedNode.left != null) {
                        newStack.add(poppedNode.left);
                    }
                    if (poppedNode.right != null) {
                        newStack.add(poppedNode.right);
                    }
                } else {
                    if (poppedNode.right != null) {
                        newStack.add(poppedNode.right);
                    }
                    if (poppedNode.left != null) {
                        newStack.add(poppedNode.left);
                    }
                }
            }
            res.add(list);
            stack = newStack;
            level ^= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(zigzagLevelOrder(TreeNode.createTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }

}
