package binaryTree;

public class MinDifferenceInBST {

    static Integer res = Integer.MAX_VALUE, pre = null;
    public static int minDiffInBST(TreeNode root) {
        if (root.left != null) minDiffInBST(root.left);
        if (pre != null) res = Math.min(res, root.val - pre);
        pre = root.val;
        if (root.right != null) minDiffInBST(root.right);
        return res;
    }


//    static int min;
//    public static int minDiffInBST(TreeNode root) {
//        min = Integer.MAX_VALUE;
//        findMin(root);
//        return min;
//    }
//
//    private static void findMin(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        if(root.left!=null) min = Math.min(root.val - rightMost(root.left).val, min);
//        if(root.right!=null) min = Math.min(leftMost(root.right).val - root.val, min);
//        findMin(root.left);
//        findMin(root.right);
//    }
//
//    private static TreeNode leftMost(TreeNode right) {
//        while (right.left != null) {
//            right = right.left;
//        }
//        return right;
//    }
//
//    private static TreeNode rightMost(TreeNode left) {
//        while (left.right != null) {
//            left = left.right;
//        }
//        return left;
//    }

    public static void main(String[] args) {
        System.out.println(minDiffInBST(TreeNode.createTree(new Integer[]{1, 0, 48, null, null, 12, 49})));
    }
}
