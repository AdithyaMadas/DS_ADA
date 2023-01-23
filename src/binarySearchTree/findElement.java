package binarySearchTree;

public class findElement {
    public static TreeNode searchBST(TreeNode root, int val) {
        while (root!=null && root.val != val) {
            if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println(searchBST(TreeNode.createTree(new Integer[]{4, 2, 7, 1, 3}), 10));
    }
}
