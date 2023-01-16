package stacksAndQueues;

import java.util.Arrays;
import java.util.Stack;

public class NextGreatestElement2 {

    public static int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % nums.length]) {
                stack.pop();
            }
            res[i % nums.length] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % nums.length]);
        }
        return res;
    }

    /*static class Pair {
        int val, index;

        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }

        public int getVal() {
            return val;
        }

        public int getIndex() {
            return index;
        }
    }
    public static int[] nextGreaterElements(int[] nums) {
        Stack<Pair> stack = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek().getVal() < nums[i]) {
                Pair ele = stack.pop();
                res[ele.getIndex()] = nums[i];
            }
            stack.push(new Pair(nums[i], i));
        }
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek().getVal() < nums[i]) {
                Pair ele = stack.pop();
                res[ele.getIndex()] = nums[i];
            }
            stack.push(new Pair(nums[i], i));
        }
        return res;
    }*/

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 3, 4, 3})));
    }
}
