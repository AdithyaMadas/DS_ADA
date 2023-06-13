package stacksAndQueues.redo;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement4 {

    public static int[] secondGreaterElement(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>(), tmp = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!s2.isEmpty() && nums[s2.peek()] < nums[i]) {
                res[s2.pop()] = nums[i];
            }
            while (!s1.isEmpty() && nums[s1.peek()] < nums[i]) {
                tmp.add(s1.pop());
            }
            while (!tmp.isEmpty()) {
                s2.add(tmp.pop());
            }
            s1.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(secondGreaterElement(new int[]{1, 17, 18, 0, 18, 10, 20, 0})));
        System.out.println(Arrays.toString(secondGreaterElement(new int[]{2, 4, 0, 9, 6})));
        System.out.println(Arrays.toString(secondGreaterElement(new int[]{3, 3})));
    }
}
