package binaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthTree {

    public static int widthOfBinaryTree(TreeNode root) {
        HashMap<Integer, Integer> leftMost = new HashMap<>();
        return getWidth(root, leftMost, 0, 1, 1);
    }

    private static int getWidth(TreeNode node, HashMap<Integer, Integer> leftMost, int currMax, int pos, int level) {
        if(node==null) return currMax;
        leftMost.computeIfAbsent(level, x -> pos);
        currMax = Math.max(currMax, pos - leftMost.get(level) + 1);
        currMax = getWidth(node.left, leftMost, currMax, pos * 2, level + 1);
        currMax = getWidth(node.right, leftMost, currMax, pos * 2 + 1, level + 1);
        return currMax;
    }

//    static class NodeLevel{
//        TreeNode node;
//        int level;
//        long width;
//
//        public NodeLevel(TreeNode node, int level, long width) {
//            this.node = node;
//            this.level = level;
//            this.width = width;
//        }
//    }
//    public static int widthOfBinaryTree(TreeNode root) {
//        Queue<NodeLevel> queue = new LinkedList<>();
//        int maxWidth = 1, currLevel = 0;
//        queue.add(new NodeLevel(root, 1, 1));
//        while (!queue.isEmpty()) {
//            NodeLevel poll = queue.poll();
//            currLevel = poll.level;
//            long currMin = poll.width, currMax = poll.width;
//            while (!queue.isEmpty() && queue.peek().level == currLevel) {
//                NodeLevel poll1 = queue.poll();
//                currMax = Math.max(currMax, poll1.width);
//                currMin = Math.min(currMin, poll1.width);
//                if(poll1.node.left!=null) queue.offer(new NodeLevel(poll1.node.left, poll1.level + 1, poll1.width * 2));
//                if (poll1.node.right != null) {
//                    queue.offer(new NodeLevel(poll1.node.right, poll1.level + 1, poll1.width * 2 + 1));
//                }
//            }
//            if(poll.node.left!=null) queue.offer(new NodeLevel(poll.node.left, poll.level + 1, poll.width * 2));
//            if (poll.node.right != null) {
//                queue.offer(new NodeLevel(poll.node.right, poll.level + 1, poll.width * 2 + 1));
//            }
//            maxWidth = (int) Math.max(maxWidth, currMax - currMin + 1);
//        }
//        return maxWidth;
//    }


    public static void main(String[] args) {
        System.out.println(widthOfBinaryTree(TreeNode.createTree(new Integer[]{1, 3, 2, 5, null, null, 9, 6, null, 7})));
    }
}
