package binaryTree;

import java.util.*;

public class BottomViewOfTree {

    static class Node
    {
        int data;
        Node left, right;

        public Node(int d)
        {
            data = d;
            left = right = null;
        }
    }

    static class NodeLevel{
        Node node;
        int level;

        public NodeLevel(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public static ArrayList<Integer> bottomView(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        Queue<NodeLevel> queue = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        queue.offer(new NodeLevel(root, 0));
        while (!queue.isEmpty()) {
            NodeLevel nodeLevel = queue.poll();
            map.put(nodeLevel.level, nodeLevel.node.data);
            if(nodeLevel.node.left!=null) queue.offer(new NodeLevel(nodeLevel.node.left, nodeLevel.level - 1));
            if(nodeLevel.node.right!=null) queue.offer(new NodeLevel(nodeLevel.node.right, nodeLevel.level + 1));
        }
        for (int i : map.values()) {
            list.add(i);
        }
        return list;
    }

}
