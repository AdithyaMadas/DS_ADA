package binaryTree;

public class LargestBST {
    static class Node {
        int data;
        Node left, right;

        public Node(int d)
        {
            data = d;
            left = right = null;
        }
    }

    static class MinMaxCount{
        int min, max, count;

        public MinMaxCount(int min, int max, int count) {
            this.min = min;
            this.max = max;
            this.count = count;
        }
    }

    static int max;

    static int largestBst(Node root) {
        max = 0;
        postOrder(root);
        return max;
    }

    private static MinMaxCount postOrder(Node node) {
        if (node == null) {
            return new MinMaxCount(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        MinMaxCount minMaxCountLeft = postOrder(node.left);
        MinMaxCount minMaxCountRight = postOrder(node.right);
        if (minMaxCountLeft.max < node.data && minMaxCountRight.min > node.data) {
            max = Math.max(max, 1 + minMaxCountLeft.count + minMaxCountRight.count);
            if(minMaxCountLeft.min == Integer.MAX_VALUE) minMaxCountLeft.min = node.data;
            if(minMaxCountRight.max == Integer.MIN_VALUE) minMaxCountRight.max = node.data;
            return new MinMaxCount(minMaxCountLeft.min, minMaxCountRight.max, 1 + minMaxCountLeft.count + minMaxCountRight.count);
        }
        return new MinMaxCount(Integer.MIN_VALUE, Integer.MAX_VALUE, 1);
    }

    public static void main(String[] args) {
        Node root = new Node(7);
        root.left = new Node(4);
        root.left.right = new Node(9);
        root.right = new Node(6);
        System.out.println(largestBst(root));
        Node node = new Node(1);
        node.left = new Node(4);
        node.left.left = new Node(6);
        node.left.right = new Node(8);
        System.out.println(largestBst(node));
    }
}
