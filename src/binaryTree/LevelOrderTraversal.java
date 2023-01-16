package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        traverseLevelOrder(root, list, 0);
        return list;
    }

    private static void traverseLevelOrder(TreeNode node, List<List<Integer>> list, int level) {
        if (node == null) {
            return;
        }
        List<Integer> levelList;
        if (list.size() <= level) {
            levelList = new ArrayList<>();
            levelList.add(node.val);
            list.add(levelList);
        } else {
            levelList = list.get(level);
            levelList.add(node.val);
            list.set(level, levelList);
        }
        traverseLevelOrder(node.left, list, level + 1);
        traverseLevelOrder(node.right, list, level + 1);
    }

    public static void main(String[] args) {

    }
}
