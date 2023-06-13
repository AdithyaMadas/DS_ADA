package dailyChallenge;

import binaryTree.TreeNode;

public class SumRootToLeafNumber {

    static class Levels{
        int currSum;
        int[] childNode;

        public Levels(int currSum, int[] childNode) {
            this.currSum = currSum;
            this.childNode = childNode;
        }
    }
    public static int sumNumbers(TreeNode root) {
        return getSum(root).currSum;
    }

    private static Levels getSum(TreeNode root) {
        if (root == null) {
            return new Levels(0,null);
        }
        Levels left = getSum(root.left);
        Levels right = getSum(root.right);
        int[] mul = new int[11];
        int currSum = 0;
        if (left.childNode != null) {
            for (int i = 0; i < 10; i++) {
                currSum += (Math.pow(10, i) * left.childNode[i] * root.val);
                mul[i + 1] += left.childNode[i];
            }
        }
        if (right.childNode != null) {
            for (int i = 0; i < 10; i++) {
                currSum += (Math.pow(10, i) * right.childNode[i] * root.val);
                mul[i + 1] += right.childNode[i];
            }
        }

        if (left.childNode == null && right.childNode == null) {
            mul[1] = 1;
            currSum += root.val;
        }
        currSum += left.currSum;
        currSum += right.currSum;
        return new Levels(currSum, mul);
    }

    public static void main(String[] args) {
        System.out.println(sumNumbers(TreeNode.createTree(new Integer[]{1, 2, 3})));
            System.out.println(sumNumbers(TreeNode.createTree(new Integer[]{4, 9, 0, 5, 1})));
    }
}
