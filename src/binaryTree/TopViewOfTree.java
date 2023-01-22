package binaryTree;

import java.util.*;

public class TopViewOfTree {

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


    static ArrayList<Integer> topView(Node root) {
        if(root==null) return new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<NodeLevel> queue = new LinkedList<>();
        queue.add(new NodeLevel(root, 0));
        while (!queue.isEmpty()) {
            NodeLevel levelNode = queue.poll();
            if (!map.containsKey(levelNode.level)) {
                map.put(levelNode.level, levelNode.node.data);
            }
            if(levelNode.node.left!=null) queue.offer(new NodeLevel(levelNode.node.left, levelNode.level - 1));
            if(levelNode.node.right!=null) queue.offer(new NodeLevel(levelNode.node.right, levelNode.level + 1));
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i : map.values()) {
            list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        Node node = new Node(2);
        node.left = new Node(1);
        node.right = new Node(4);
        node.right.left = new Node(3);
        node.right.right = new Node(6);

        System.out.println(topView(node));
    }
}
