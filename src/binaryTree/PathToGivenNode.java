package binaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class PathToGivenNode {
    public static ArrayList<Integer> solve(TreeNode A, int B) {
        Stack<Integer> stack = new Stack<>();
        findPath(A, stack, B);
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    private static boolean findPath(TreeNode node, Stack<Integer> stack, int b) {
        if (node == null) {
            return false;
        }
        if (node.val == b) {
            stack.add(b);
            return true;
        }
        if (findPath(node.left, stack, b) || findPath(node.right, stack, b)) {
            stack.add(node.val);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solve(TreeNode.createTree(new Integer[]{1, 2, 3, 4, 5, 6, 7}), 1));
    }
}
