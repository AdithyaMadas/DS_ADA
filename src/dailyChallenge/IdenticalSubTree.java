package dailyChallenge;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class IdenticalSubTree {
    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        dfs(root, ans, new HashMap<>(), new HashSet<>());
        return ans;
    }

    private static int dfs(TreeNode root, List<TreeNode> ans, HashMap<String, Integer> treeToID, HashSet<Integer> set) {
        if (root == null) {
            return 0;
        }
        String id = dfs(root.left, ans, treeToID, set) + "," + root.val + "," + dfs(root.right, ans, treeToID, set);
        if (treeToID.containsKey(id)) {
            Integer integer = treeToID.get(id);
            if (!set.contains(integer)) {
                ans.add(root);
                set.add(integer);
            }
        } else {
            treeToID.put(id, treeToID.size() + 1);
        }
        return treeToID.get(id);
    }


    public static void main(String[] args) {

        System.out.println(findDuplicateSubtrees(TreeNode.createTree(new Integer[]{1, 2, 3, 4, null, 2, 4, null, null, 4})));
    }
}
