package binaryTree;

import java.util.ArrayList;

public class BoundaryTraversal {
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
    static ArrayList<Integer> boundary(Node node) {
        if(node==null) return new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(node.data);
        if (node.left != null) {
            traverseLeft(node.left, list);
            traverseLeaf(node, list);
            if (node.right != null) {
                traverseRight(node, list);
            }
        } else {
            traverseLeaf(node, list);
            if (node.right != null) {
                traverseRight(node.right, list);
            }
        }
        return list;
    }

    private static void traverseRight(Node node, ArrayList<Integer> list) {
        if (node.right == null) {
            if (node.left == null) {
                return;
            } else {
                traverseRight(node.left, list);
            }
        } else {
            traverseRight(node.right, list);
        }
        list.add(node.data);
    }

    private static void traverseLeaf(Node node, ArrayList<Integer> list) {
        if (node.left == null && node.right == null) {
            list.add(node.data);
            return;
        }
        if (node.left != null) {
            traverseLeaf(node.left, list);
        }
        if (node.right != null) {
            traverseLeaf(node.right, list);
        }
    }

    private static void traverseLeft(Node node, ArrayList<Integer> list) {
        if (node.left == null && node.right == null) {
            return;
        }
        list.add(node.data);
        if (node.left == null) {
            traverseRight(node.right, list);
        }
        traverseLeft(node.left, list);
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(4);
        node.left.right.left = new Node(8);
        node.left.right.right = new Node(9);
        node.right.left = new Node(6);
        node.right.right = new Node(7);

        System.out.println(boundary(node));
    }
}
