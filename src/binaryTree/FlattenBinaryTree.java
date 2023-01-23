package binaryTree;

public class FlattenBinaryTree {
    public static void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                curr = curr.right;
            } else {
                TreeNode left = curr.left;
                while (left.right != null) {
                    left = left.right;
                }
                left.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new Integer[]{1, 2, 5, 3, 4, null, 6});
        flatten(tree);
        while (tree != null) {
            System.out.println(tree.val + "->");
            tree = tree.right;
        }
    }
}
