package binaryTree;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-paths/
public class BinaryTreePaths {
    public static List<String> binaryTreePaths(TreeNode node) {
        if (node == null) {
            return new ArrayList<>();
        }
        if (node.left == null && node.right == null) {
            return new ArrayList<String>() {{
                add(String.valueOf(node.val));
            }};
        }
        String s = String.valueOf(node.val);
        List<String> list = new ArrayList<>();
        for (String child : binaryTreePaths(node.left)) {
            list.add(s + "->" + child);
        }
        for (String child : binaryTreePaths(node.right)) {
            list.add(s + "->" + child);
        }
        return list;
    }


    public static void main(String[] args) {
        System.out.println(binaryTreePaths(TreeNode.createTree(new Integer[]{1, 2, 3, null, 5})));
    }

}
