package binarySearchTree;

public class BSTFromPreOrder {
    public static TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, 0, preorder.length - 1);
    }

    private static TreeNode bstFromPreorder(int[] preorder, int start, int end) {
        if (end - start < 0) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[start]);
        int endForLeft = start + 1;
        while (endForLeft < preorder.length && preorder[endForLeft] < preorder[start]) {
            endForLeft++;
        }
        node.left = bstFromPreorder(preorder, start + 1, endForLeft - 1);
        node.right = bstFromPreorder(preorder, endForLeft, end);
        return node;
    }

    public static void main(String[] args) {
        TreeNode node = bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
        System.out.println(node);
    }
}
