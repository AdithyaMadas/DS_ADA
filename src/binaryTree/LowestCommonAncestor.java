package binaryTree;

import java.util.*;

public class LowestCommonAncestor {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.val == p.val || root.val == q.val)  return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)   return root;
        return left != null ? left : right;
    }

    //    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        LinkedHashSet<TreeNode> set = new LinkedHashSet<>();
//        findPathToP(root, set, p);
//        LinkedHashSet<TreeNode> set1 = new LinkedHashSet<>();
//        findPathToP(root, set1, q);

//        for (int i = 0; i < treeNodes.length; i++) {
//            if (set.contains(treeNodes[i])) {
//                return treeNodes[i];
//            }
//        }
//        return null;
//    }
//
//    private static boolean findPathToP(TreeNode node, Set<TreeNode> set, TreeNode p) {
//        if(node==null) return false;
//        if (node.val == p.val) {
//            set.add(node);
//            return true;
//        }
//        if(findPathToP(node.left, set, p)){
//            set.add(node);
//            return true;
//        }
//        if(findPathToP(node.right, set, p)){
//            set.add(node);
//            return true;
//        }
//        return false;
//    }


    public static void main(String[] args) {
      System.out.println(lowestCommonAncestor(TreeNode.createTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}), new TreeNode(5), new TreeNode(4)).val);
        System.out.println(lowestCommonAncestor(TreeNode.createTree(new Integer[]{1, 2}), new TreeNode(1), new TreeNode(2)).val);

    }
}
