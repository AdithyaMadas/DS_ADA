package binaryTree;

public class ChildrenParentSum {
    static class Node{
        int data;
        Node left,right;

        Node(int key)
        {
            data = key;
            left = right = null;
        }
    }
    public static int isSumProperty(Node root) {
        if(root==null || (root.right==null && root.left == null)) return 1;
        int sum = 0;
        if(root.left!=null) sum += root.left.data;
        if (root.right != null) {
            sum += root.right.data;
        }
        if(sum!=root.data) return 0;
        return isSumProperty(root.left) & isSumProperty(root.right);
    }

    public static void main(String[] args) {
        Node node = new Node(20);
        node.left = new Node(10);
        node.right = new Node(10);
        System.out.println(isSumProperty(node));
    }
}
