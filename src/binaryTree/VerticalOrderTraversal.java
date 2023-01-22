package binaryTree;

import java.util.*;

public class VerticalOrderTraversal {

    static class Node implements Comparable<Node> {
        int val, row;

        public Node(int val, int row) {
            this.val = val;
            this.row = row;
        }

        @Override
        public int compareTo(Node o) {
            if (row == o.row) {
                return val - o.val;
            }
            return row - o.row;
        }
    }
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, PriorityQueue<Node>> treeMap = new TreeMap<>();
        traverseTree(root, 0, 0, treeMap);
        List<List<Integer>> res = new ArrayList<>();
        for (PriorityQueue<Node> pq : treeMap.values()) {
            List<Integer> list = new ArrayList<>();
            while (!pq.isEmpty()) {
                list.add(pq.poll().val);
            }
            res.add(list);
        }
        return res;
    }

    private static void traverseTree(TreeNode node, int level, int row, TreeMap<Integer, PriorityQueue<Node>> treeMap) {
        if(node==null) return;
        treeMap.computeIfAbsent(level, v -> new PriorityQueue<Node>()).offer(new Node(node.val, row));
        traverseTree(node.left, level - 1, row+1, treeMap);
        traverseTree(node.right, level + 1, row+1, treeMap);
    }
    
    public static void main(String[] args) {
        System.out.println(verticalTraversal(TreeNode.createTree(new Integer[]{1, 2, 3, 4, 6, 5, 7})));
    }

}
