package binarySearchTree;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode createTree(Integer[] nums) {
        TreeNode root = new TreeNode(nums[0]);
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int i = 1;
        while (i < nums.length) {
            TreeNode parent = queue.poll();

            Integer leftNum = nums[i++];

            if (leftNum != null) {
                TreeNode left = new TreeNode(leftNum);
                parent.left = left;

                queue.add(left);
            }

            if (i < nums.length) {
                Integer rightNum = nums[i++];

                if (rightNum != null) {
                    TreeNode right = new TreeNode(rightNum);
                    parent.right = right;

                    queue.add(right);
                }
            }
        }
        return root;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode node = (TreeNode) o;
        return val == node.val;
    }

    @Override
    public int hashCode() {
        return val;
    }
}
