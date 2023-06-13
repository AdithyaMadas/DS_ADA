package stacksAndQueues.redo;

import java.util.Arrays;
import java.util.Stack;

public class nextGreaterElement2 {
    public static int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> monotonicStack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            while (!monotonicStack.isEmpty() && monotonicStack.peek() <= nums[i % nums.length]) {
                monotonicStack.pop();
            }
            res[i % nums.length] = monotonicStack.isEmpty() ? -1 : monotonicStack.peek();
            monotonicStack.add(nums[i % nums.length]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 1})));
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 3, 4, 3})));
    }
}
