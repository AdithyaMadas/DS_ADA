package binaryTree;

public class DiameterOfTree {

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = maxDepth(root.left) + maxDepth(root.right);
        int diameterLeft = diameterOfBinaryTree(root.left);
        int diameterRight = diameterOfBinaryTree(root.right);

        if(max>diameterLeft){
            if(max>diameterRight){
                return max;
            }
            return diameterRight;
        }
        if(diameterLeft>diameterRight){
            return diameterLeft;
        }
        return diameterRight;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right = new TreeNode(3);
        System.out.println(diameterOfBinaryTree(node));

    }
}
