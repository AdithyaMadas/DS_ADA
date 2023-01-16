package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;

//https://www.youtube.com/watch?v=CZQGRp93K4k
public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int res[] = new int[nums.length - k + 1];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (!stack.isEmpty() && stack.peekLast() < i - k + 1) {
                stack.pollLast();
            }
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                stack.poll();
            }
            stack.push(i);
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[stack.peekLast()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{7, 2, 4}, 2)));
    }

}
