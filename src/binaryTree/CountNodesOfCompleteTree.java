package binaryTree;

public class CountNodesOfCompleteTree {
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (checkIfCompleteBT(root)) {
            return getHeight(root);
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private static int getHeight(TreeNode root) {
        int height = leftHeight(root);
        return (int) (Math.pow(2, height) - 1);
    }

    private static boolean checkIfCompleteBT(TreeNode node) {
        return leftHeight(node) == rightHeight(node);
    }

    private static int leftHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + leftHeight(node.left);
    }

    private static int rightHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + rightHeight(node.right);
    }

    public static void main(String[] args) {
        System.out.println(countNodes(TreeNode.createTree(new Integer[]{1, 2, 3, 4, 5, 6})));
    }
}
