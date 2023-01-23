package binarySearchTree;

public class FloorOfX {
    public static int floor(Node root, int x) {
        if(root==null) return -1;
        if (root.data == x) {
            return x;
        } else if (root.data > x) {
            return floor(root.left, x);
        } else {
            int ceil = floor(root.right, x);
            if (ceil != -1) {
                return ceil;
            } else {
                return root.data;
            }
        }
    }

    public static void main(String[] args) {

    }
}
