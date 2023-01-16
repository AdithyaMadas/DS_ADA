package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllOrderInOneTraversal {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static class Pair {
        TreeNode node;
        int count;
        public Pair(TreeNode node) {
            this.node = node;
            count = 1;
        }
    }

    static List<List<Integer>> allTraversals(TreeNode root){
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root));

        while (!stack.isEmpty()) {
            Pair nodeCount = stack.pop();
            if (nodeCount.count == 1) {
                inOrder.add(nodeCount.node.val);
                nodeCount.count++;
                stack.push(nodeCount);
                if (nodeCount.node.left != null) {
                    stack.push(new Pair(nodeCount.node.left));
                }
            }
            else if (nodeCount.count == 2) {
                preOrder.add(nodeCount.node.val);
                nodeCount.count++;
                stack.push(nodeCount);
                if (nodeCount.node.right != null) {
                    stack.push(new Pair(nodeCount.node.right));
                }
            }
            else if (nodeCount.count == 3) {
                postOrder.add(nodeCount.node.val);
            }
        }

        List<List<Integer>> res = new ArrayList<List<Integer>>() {{
            add(preOrder);
            add(inOrder);
            add(postOrder);
        }};

        return res;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        System.out.println(allTraversals(node));
    }
}
