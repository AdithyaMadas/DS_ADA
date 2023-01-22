package binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistanceKFromTree {
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(k==0) return new ArrayList<Integer>() {{
            add(target.val);
        }};
        List<Integer> l = new ArrayList<>();
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();
        createTreeMap(root, map, null);
        getAllNodeAtDistanceK(target, map, k, l, target);
        return l;
    }

    private static void getAllNodeAtDistanceK(TreeNode target, Map<TreeNode, List<TreeNode>> map, int k, List<Integer> l, TreeNode parent) {
        if (k == 1) {
            for (TreeNode i : map.getOrDefault(target, new ArrayList<>())) {
                if (i == parent) {
                    continue;
                }
                l.add(i.val);
            }
            return;
        }
        for (TreeNode i : map.getOrDefault(target, new ArrayList<>())) {
            if (i == parent) {
                continue;
            }
            getAllNodeAtDistanceK(i, map, k - 1, l, target);
        }
    }


    private static void createTreeMap(TreeNode root, Map<TreeNode, List<TreeNode>> map, TreeNode parent) {
        if (root == null) {
            return;
        }
        if(parent!=null) map.computeIfAbsent(root, val -> new ArrayList<>()).add(parent);
        if(root.left!=null) map.computeIfAbsent(root, val -> new ArrayList<>()).add(root.left);
        if(root.right!=null) map.computeIfAbsent(root, val -> new ArrayList<>()).add(root.right);
        createTreeMap(root.left, map, root);
        createTreeMap(root.right, map, root);
    }

    public static void main(String[] args) {
//        TreeNode tree = TreeNode.createTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
//        System.out.println(distanceK(tree, tree.left, 2));
        TreeNode tree = TreeNode.createTree(new Integer[]{1});
        System.out.println(distanceK(tree, tree, 0));
    }

}
