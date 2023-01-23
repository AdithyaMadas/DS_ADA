package binarySearchTree;

import java.util.Stack;

public class deleteKthSmallest {

    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (k != 0) {
            TreeNode pop = stack.pop();
            k--;
            if(k==0) return pop.val;
            TreeNode right = pop.right;
            while (right != null) {
                stack.add(right);
                right = right.left;
            }
        }
        return -1;
    }



//    public static int kthSmallest(TreeNode root, int k) {
//        if (root == null) {
//            return -1;
//        }
//        int greaterThan = CountNoOfNodes(root.left);
//        if (k == greaterThan + 1) {
//            return root.val;
//        } else if (k < greaterThan + 1) {
//            return kthSmallest(root.left, k);
//        } else {
//            return kthSmallest(root.right, k - greaterThan - 1);
//        }
//    }
//
//    private static int CountNoOfNodes(TreeNode left) {
//        if (left == null) {
//            return 0;
//        }
//        return 1 + CountNoOfNodes(left.left) + CountNoOfNodes(left.right);
//    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new Integer[]{5, 3, 6, 2, 4, null, null, 1});
        System.out.println(kthSmallest(tree, 4));
    }
}
