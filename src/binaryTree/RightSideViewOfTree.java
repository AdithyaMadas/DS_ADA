package binaryTree;

import java.util.*;

public class RightSideViewOfTree {

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        rightTraverse(root, list, 0);
        return list;
    }

    private static void rightTraverse(TreeNode node, List<Integer> list, int level) {
        if (node == null) {
            return;
        }
        if (level == list.size()) {
            list.add(node.val);
        }
        rightTraverse(node.right, list, level + 1);
        rightTraverse(node.left, list, level + 1);

    }
//    static class LevelNode{
//        TreeNode node;
//        int level;
//
//        public LevelNode(TreeNode node, int level) {
//            this.node = node;
//            this.level = level;
//        }
//    }
//
//    public static List<Integer> rightSideView(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        if(root==null) return list;
//        Queue<LevelNode> queue = new LinkedList<>();
//        queue.offer(new LevelNode(root, 0));
//        Set<Integer> levels = new HashSet<>();
//        while (!queue.isEmpty()) {
//            LevelNode levelNode = queue.poll();
//            if (!levels.contains(levelNode.level)) {
//                list.add(levelNode.node.val);
//                levels.add(levelNode.level);
//            }
//            if(levelNode.node.right!=null) queue.offer(new LevelNode(levelNode.node.right, levelNode.level + 1));
//            if(levelNode.node.left!=null) queue.offer(new LevelNode(levelNode.node.left, levelNode.level + 1));
//        }
//        return list;
//    }

    public static void main(String[] args) {
        System.out.println(rightSideView(TreeNode.createTree(new Integer[]{1, null, 3})));
    }
}
