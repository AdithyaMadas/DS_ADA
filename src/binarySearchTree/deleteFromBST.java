package binarySearchTree;

public class deleteFromBST {
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            int val = findMin(root.right);
            root.right = deleteNode(root.right, val);
            root.val = val;
        }
        return root;
    }

    private static int findMin(TreeNode right) {
        while (right.left != null) {
            right = right.left;
        }
        return right.val;
    }

    public static void main(String[] args) {
        TreeNode treeNode = deleteNode(TreeNode.createTree(new Integer[]{5, 3, 6, 2, 4, null, 7}), 3);
        System.out.println(treeNode);
    }
}
