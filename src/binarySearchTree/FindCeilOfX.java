package binarySearchTree;

public class FindCeilOfX {

    static int findCeil(Node root, int key) {
        if (root == null) return -1;
        // Code here
        int nextGreatest = Integer.MAX_VALUE;
        while (root != null) {
            if (root.data == key) {
                nextGreatest = key;
                break;
            } else if (root.data < key) {
                root = root.right;
            } else {
                nextGreatest = Math.min(nextGreatest, root.data);
                root = root.left;
            }
        }
        return nextGreatest == Integer.MAX_VALUE ? -1 : nextGreatest;
    }

    public static void main(String[] args) {
        Node node = new Node(5);
        node.right = new Node(6);
        node.right.right = new Node(7);
        node.left = new Node(4);
        node.left.left = new Node(2);
        node.left.left.left = new Node(1);
        System.out.println(findCeil(node, 3));
    }

}

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}
