package binaryTree;

import java.util.HashMap;

public class BuildTreeFromInOrderPostOrder {

    static HashMap<Integer, Integer> map;
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(map, postorder, 0, postorder.length - 1, 0);
    }
    private static TreeNode buildTree(HashMap<Integer, Integer> map, int[] postorder, int start, int end, int inOrderStart) {
        if (end - start < 0 || start < 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[end]);
        int pos = map.get(postorder[end]) - inOrderStart;
        root.left = buildTree(map, postorder, start, start+ pos - 1, inOrderStart);
        root.right = buildTree(map, postorder, start+pos, end - 1, inOrderStart + pos + 1);
        return root;
    }

    public static void main(String[] args) {
        TreeNode node = buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(node);
    }
}
