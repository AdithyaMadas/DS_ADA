package stacksAndQueues.redo;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        Arrays.fill(nums1, -1);
        ArrayDeque<Integer> monotonicStack = new ArrayDeque<>();
        for (int i : nums2) {
            if (monotonicStack.isEmpty() || monotonicStack.peek() > i) {
                monotonicStack.offerFirst(i);
            } else {
                while (!monotonicStack.isEmpty() && monotonicStack.peek() < i) {
                    int ele = monotonicStack.pop();
                    if (map.containsKey(ele)) {
                        nums1[map.get(ele)] = i;
                    }
                }
                monotonicStack.offerFirst(i);
            }
        }
        return nums1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }
}
