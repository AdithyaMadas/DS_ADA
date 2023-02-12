package binarySearchTree;

public class leastCommonAncestor {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        if ((root.val > p.val && root.val < q.val) || (root.val > q.val && root.val < p.val)) {
            return root;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
        TreeNode treeNode = lowestCommonAncestor(tree, tree.left, tree.right);
        System.out.println(treeNode.val);
    }
}
