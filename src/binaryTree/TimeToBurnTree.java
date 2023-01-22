package binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeToBurnTree {
    static class Node {
    	int data;
    	Node left;
    	Node right;

    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }

    public static int minTime(Node root, int targetValue) {
        Map<Node, List<Node>> map = new HashMap<>();
        Node target = createMap(root, map, targetValue, null);
        return getTime(target, map, target, 0);
    }

    private static int getTime(Node target, Map<Node, List<Node>> map, Node parent, int currTime) {
        int maxTime = currTime;
        for (Node i : map.getOrDefault(target, new ArrayList<>())) {
            if (i == parent) {
                continue;
            }
            maxTime = Math.max(maxTime, getTime(i, map, target, currTime + 1));
        }
        return maxTime;
    }

    private static Node createMap(Node root, Map<Node, List<Node>> map, int targetValue, Node parent) {
        if (root == null) {
            return null;
        }
        if(parent!=null) map.computeIfAbsent(root, val -> new ArrayList<>()).add(parent);
        if(root.left!=null) map.computeIfAbsent(root, val -> new ArrayList<>()).add(root.left);
        if(root.right!=null) map.computeIfAbsent(root, val -> new ArrayList<>()).add(root.right);

        Node map1 = createMap(root.left, map, targetValue, root);
        Node map2 = createMap(root.right, map, targetValue, root);
        Node toReturn = null;
        if (map1 != null) {
            toReturn = map1;
        } else if (map2 != null) {
            toReturn = map2;
        } else if (root.data == targetValue) {
            toReturn = root;
        }
        return toReturn;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(8);
        root.right = new Node(3);
        root.right.right = new Node(6);
        root.right.right.right = new Node(9);
        root.right.right.right.right = new Node(10);

        System.out.println(minTime(root, 1));
    }

}
