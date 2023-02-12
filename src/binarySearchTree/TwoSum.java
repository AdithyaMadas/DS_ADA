package binarySearchTree;

import java.util.Stack;

public class TwoSum {

    static class BSTAscendingIterator{
        Stack<TreeNode> stack;

        public BSTAscendingIterator(TreeNode node) {
            stack = new Stack<>();
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public int next() {
            TreeNode pop = stack.pop();
            int toRet = pop.val;
            if (pop.right != null) {
                pop = pop.right;
                while (pop != null) {
                    stack.push(pop);
                    pop = pop.left;
                }
            }
            return toRet;
        }

        public TreeNode peek(){
            return stack.peek();
        }
    }

    static class BSTDescendingIterator{
        Stack<TreeNode> stack;

        public BSTDescendingIterator(TreeNode node) {
            stack = new Stack<>();
            while (node != null) {
                stack.push(node);
                node = node.right;
            }
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public int next() {
            TreeNode pop = stack.pop();
            int toRet = pop.val;
            if (pop.left != null) {
                pop = pop.left;
                while (pop != null) {
                    stack.push(pop);
                    pop = pop.right;
                }
            }
            return toRet;
        }

        public TreeNode peek(){
            return stack.peek();
        }
    }

    public static boolean findTarget(TreeNode root, int k) {
        BSTAscendingIterator ascendingIterator = new BSTAscendingIterator(root);
        BSTDescendingIterator descendingIterator = new BSTDescendingIterator(root);
        while (ascendingIterator.peek() != descendingIterator.peek()) {
            int sum = ascendingIterator.peek().val + descendingIterator.peek().val;
            if (sum > k) {
                descendingIterator.next();
            } else if (sum < k) {
                ascendingIterator.next();
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(findTarget(TreeNode.createTree(new Integer[]{2, null, 3}), 6));
    }
}
