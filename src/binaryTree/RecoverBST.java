package binaryTree;

public class RecoverBST {

    static TreeNode x;
    static TreeNode y;
    static TreeNode prev;
    public static void recoverTree(TreeNode root) {
        x = y = null;
        prev = null;
        inOrder(root);
        swap();
        return;
    }

    private static void swap() {
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }

    private static void inOrder(TreeNode curr) {
        if (curr == null) {
            return;
        }
        if (curr.left != null) {
            inOrder(curr.left);
        }
        if (prev!=null && curr.val < prev.val) {
            if (x == null) {
                x = prev;
                y = curr;
            } else {
                y = curr;
                return;
            }
        }
        prev = curr;
        if (curr.right != null) {
            inOrder(curr.right);
        }
    }


//    public static void recoverTree(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        TreeNode max = findMax(root.left);
//        TreeNode min = findMin(root.right);
//        if (max != null && max.val > root.val && min != null && min.val < root.val) {
//            int tmp = max.val;
//            max.val = min.val;
//            min.val = tmp;
//        }else if (max != null && max.val > root.val) {
//            int tmp = max.val;
//            max.val = root.val;
//            root.val = tmp;
//        } else if (min != null && min.val < root.val) {
//            int tmp = min.val;
//            min.val = root.val;
//            root.val = tmp;
//        } else {
//            recoverTree(root.left);
//            recoverTree(root.right);
//        }
//    }
//
//    private static TreeNode findMin(TreeNode left) {
//        if (left == null) {
//            return null;
//        }
//        TreeNode maxLeft = findMin(left.left);
//        TreeNode maxRight = findMin(left.right);
//        TreeNode max = null;
//        if (maxLeft != null) {
//            if (maxLeft.val < left.val) {
//                max = maxLeft;
//            }
//        }
//        if (maxRight != null) {
//            if (max != null && maxRight.val < max.val) {
//                max = maxRight;
//            } else if (max == null && maxRight.val < left.val) {
//                max = maxRight;
//            }
//        }
//        if (max != null) {
//            return max;
//        } else {
//            return left;
//        }
//    }
//    private static TreeNode findMax(TreeNode left) {
//        if (left == null) {
//            return null;
//        }
//        TreeNode maxLeft = findMax(left.left);
//        TreeNode maxRight = findMax(left.right);
//        TreeNode max = null;
//        if (maxLeft != null) {
//            if (maxLeft.val > left.val) {
//                max = maxLeft;
//            }
//        }
//        if (maxRight != null) {
//            if (max != null && maxRight.val > max.val) {
//                max = maxRight;
//            } else if (max == null && maxRight.val > left.val) {
//                max = maxRight;
//            }
//        }
//        if (max != null) {
//            return max;
//        } else {
//            return left;
//        }
//    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new Integer[]{5, 3, 9, -2147483648, 2});
        recoverTree(tree);
        System.out.println(tree);
    }
}
