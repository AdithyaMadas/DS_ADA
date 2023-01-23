package binarySearchTree;

public class InsertIntoBST {

        public static TreeNode insertIntoBST(TreeNode root, int val) {
            if(root==null) return new TreeNode(val);
            if (val < root.val) {
                root.left = insertIntoBST(root.left, val);
            } else {
                root.right = insertIntoBST(root.right, val);
            }
            return root;
        }

//    public static TreeNode insertIntoBST(TreeNode root, int val) {
//        if(root==null) return new TreeNode(val);
//        TreeNode curr = root;
//        while (true) {
//            if (val < curr.val) {
//                if (curr.left != null) {
//                    curr = curr.left;
//                } else {
//                    break;
//                }
//            } else {
//                if (curr.right != null) {
//                    curr = curr.right;
//                } else {
//                    break;
//                }
//            }
//        }
//        if (val < curr.val) {
//            curr.left = new TreeNode(val);
//        } else {
//            curr.right = new TreeNode(val);
//        }
//        return root;
//    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new Integer[]{4, 2, 7, 1, 3});
        System.out.println(insertIntoBST(tree, 5));
        System.out.println(tree);
    }

}
