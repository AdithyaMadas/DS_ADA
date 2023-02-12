package binarySearchTree;

public class BSTIterator {

    TreeNode currNode;
    public BSTIterator(TreeNode root) {
        convert(root);
        currNode = findLeftMost(root);
    }

    private void convert(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            convert(root.left);
            TreeNode right = findRightMost(root.left);
            right.right = root;
        }
        if (root.right != null) {
            convert(root.right);
            root.right = findLeftMost(root.right);
        }
    }

    private TreeNode findLeftMost(TreeNode right) {
        while (right.left != null) {
            right = right.left;
        }
        return right;
    }

    private TreeNode findRightMost(TreeNode left) {
        while (left.right != null) {
            left = left.right;
        }
        return left;
    }


    public int next() {
        int ret = currNode.val;
        currNode = currNode.right;
        return ret;
    }

    public boolean hasNext() {
        return currNode != null;
    }

    public static void main(String[] args) {
        BSTIterator iterator = new BSTIterator(TreeNode.createTree(new Integer[]{7, 3, 15, null, null, 9, 20}));
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }
}
