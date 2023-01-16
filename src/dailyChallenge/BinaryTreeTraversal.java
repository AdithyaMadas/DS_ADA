package dailyChallenge;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null) {
                return null;
            }
            ArrayList<Integer> integers = new ArrayList<>();
            List<Integer> list = preorderTraversal(root.left);
            if (list != null) {
                integers.addAll(list);
            }
            integers.add(root.val);
            list = preorderTraversal(root.right);
            if (list != null) {
                integers.addAll(list);
            }
            integers.addAll(list);

            return integers;
        }
    }
}
